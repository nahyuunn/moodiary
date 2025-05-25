package com.moodiary.moodiary_back.controller;


import com.moodiary.moodiary_back.dto.request.LoginRequestDto;
import com.moodiary.moodiary_back.dto.request.SignUpRequestDto;
import com.moodiary.moodiary_back.dto.response.LoginResponseDto;
import com.moodiary.moodiary_back.dto.response.SignUpResponseDto;
import com.moodiary.moodiary_back.service.AuthService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/open/auth")
@RequiredArgsConstructor
public class OpenAuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<? super SignUpResponseDto> signup(
            @RequestBody @Valid SignUpRequestDto requestBody
            ) {
        ResponseEntity<? super SignUpResponseDto> response = authService.signup(requestBody);
        return response;
    }

    @PostMapping("/login")
    public ResponseEntity<? super LoginResponseDto> login(
            @RequestBody @Valid LoginRequestDto requestBody,
            HttpServletResponse httpServletResponse
            ) {
        ResponseEntity<? super LoginResponseDto> response = authService.login(requestBody, httpServletResponse);
        return response;
    }

}
