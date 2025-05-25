package com.moodiary.moodiary_back.service;

import com.moodiary.moodiary_back.dto.ResponseDto;
import com.moodiary.moodiary_back.dto.request.ChangeNicknameRequestDto;
import com.moodiary.moodiary_back.dto.request.ChangePWRequestDto;
import com.moodiary.moodiary_back.dto.request.LoginRequestDto;
import com.moodiary.moodiary_back.dto.request.SignUpRequestDto;
import com.moodiary.moodiary_back.dto.response.ChangeNicknameResponseDto;
import com.moodiary.moodiary_back.dto.response.ChangePWResponseDto;
import com.moodiary.moodiary_back.dto.response.LoginResponseDto;
import com.moodiary.moodiary_back.dto.response.SignUpResponseDto;
import com.moodiary.moodiary_back.entity.User;
import com.moodiary.moodiary_back.filter.JWTUtil;
import com.moodiary.moodiary_back.repository.UserRepository;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final PasswordEncoder passwordEncoder;
    private final JWTUtil jwtUtil;
    private final UserRepository userRepository;

    public ResponseEntity<? super SignUpResponseDto> signup(SignUpRequestDto dto) {
        try {
            String email = dto.getUserEmail();
            boolean existsByEmail = userRepository.existsByUserEmail(email);
            if (existsByEmail) return SignUpResponseDto.duplicateEmail();

            String password = dto.getPassword();
            String encodedPassword = passwordEncoder.encode(password);
            dto.setPassword(encodedPassword);

            User userEntity = new User(dto);
            userRepository.save(userEntity);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.databaseError();
        }
        return SignUpResponseDto.success();
    }

    public ResponseEntity<? super LoginResponseDto> login(LoginRequestDto dto, HttpServletResponse response) {
        String access = null;
        String refresh = null;

        try {

            String email = dto.getEmail();
            User userEntity = userRepository.findByUserEmail(email);
            if (userEntity == null) return LoginResponseDto.signInFail();

            String password = dto.getPassword();
            String encodedUserPW = userEntity.getPassword();
            boolean isMatched = passwordEncoder.matches(password, encodedUserPW);
            if (!isMatched) return LoginResponseDto.signInFail();

            access = jwtUtil.createJwt("access", email,600000L);
            refresh = jwtUtil.createJwt("refresh", email,86400000L);

            response.addCookie(createCookie("refresh", refresh));

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return LoginResponseDto.success(access, refresh, response);

    }

    public ResponseEntity<? super ChangePWResponseDto> changePW(
            String userEmail,
            ChangePWRequestDto dto) {

        try {

            User userEntity = userRepository.findByUserEmail(userEmail);

            //입력받은 originPW
            String originPW = dto.getPassword();

            //DB에 저장되어 있는 originPW
            String encodedOriginPW = userEntity.getPassword();

            boolean isMatched = passwordEncoder.matches(originPW, encodedOriginPW);
            if (!isMatched) return ChangePWResponseDto.fail();

            String newPW = dto.getNewPassword();
            String encodedNewPW = passwordEncoder.encode(newPW);

            // 암호화된 새 비밀번호를 엔티티에 저장
            userEntity.setPassword(encodedNewPW);
            userRepository.save(userEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ChangePWResponseDto.success();
    }

    public ResponseEntity<? super ChangeNicknameResponseDto> changeNickname(
            String userEmail,
            ChangeNicknameRequestDto dto) {
        try {
            User userEntity = userRepository.findByUserEmail(userEmail);
            // 입력받은 새 닉네임
            String newNickname = dto.getNickname();
            // 기존 닉네임
            String originNickname = userEntity.getNickname();
            // 비교
            boolean isMatched = newNickname.equals(originNickname);
            // 같으면 return status unchanged
            if (isMatched) return ChangeNicknameResponseDto.nicknameUnchanged();
            //set nickname
            userEntity.setNickname(newNickname);
            userRepository.save(userEntity);
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ChangeNicknameResponseDto.success();
    }

    private Cookie createCookie(String key, String value) {
        Cookie cookie = new Cookie(key, value);
        cookie.setMaxAge(24*60*60);
        cookie.setSecure(true);
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        return cookie;
    }
}
