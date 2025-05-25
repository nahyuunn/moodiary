package com.moodiary.moodiary_back.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ChangeNicknameRequestDto {

    @NotBlank
    private String nickname;

}
