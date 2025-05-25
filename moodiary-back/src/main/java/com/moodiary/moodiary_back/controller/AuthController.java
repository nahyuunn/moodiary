package com.moodiary.moodiary_back.controller;

import com.moodiary.moodiary_back.dto.request.ChangeNicknameRequestDto;
import com.moodiary.moodiary_back.dto.request.ChangePWRequestDto;
import com.moodiary.moodiary_back.dto.response.ChangeNicknameResponseDto;
import com.moodiary.moodiary_back.dto.response.ChangePWResponseDto;
import com.moodiary.moodiary_back.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    @PostMapping("/password")
    public ResponseEntity<? super ChangePWResponseDto> changePW(
            @AuthenticationPrincipal String userEmail,
            @RequestBody @Valid ChangePWRequestDto requestBody
    ) {
        ResponseEntity<? super ChangePWResponseDto> response = authService.changePW(userEmail, requestBody);
        return response;
    }

    @PostMapping("/nickname")
    public ResponseEntity<? super ChangeNicknameResponseDto> changeNickname(
            @AuthenticationPrincipal String userEmail,
            @RequestBody @Valid ChangeNicknameRequestDto requestBody
    ) {
        ResponseEntity<? super ChangeNicknameResponseDto> response = authService.changeNickname(userEmail, requestBody);
        return response;
    }

}
