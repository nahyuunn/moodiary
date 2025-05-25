package com.moodiary.moodiary_back.dto.request;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class SignUpRequestDto {
    @NotBlank @Email
    private String userEmail;
    @NotBlank
    private String nickname;
    @NotBlank @Size(min=8, max=20)
    private String password;
}
