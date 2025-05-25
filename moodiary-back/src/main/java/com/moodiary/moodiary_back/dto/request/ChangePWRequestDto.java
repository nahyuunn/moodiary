package com.moodiary.moodiary_back.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ChangePWRequestDto {
    @NotBlank
    @Size(min=8, max=20)
    private String password;

    @NotBlank
    @Size(min=8, max=20)
    private String newPassword;
}
