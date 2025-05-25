package com.moodiary.moodiary_back.dto.response;

import com.moodiary.moodiary_back.common.ResponseCode;
import com.moodiary.moodiary_back.common.ResponseMessage;
import com.moodiary.moodiary_back.dto.ResponseDto;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
public class ChangeNicknameResponseDto extends ResponseDto {

    public ChangeNicknameResponseDto() {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);}

    public static ResponseEntity<ChangeNicknameResponseDto> success() {
        ChangeNicknameResponseDto result = new ChangeNicknameResponseDto();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    public static ResponseEntity<ResponseDto> nicknameUnchanged() {
        ResponseDto result = new ResponseDto(ResponseCode.SEND_TOAST_MESSAGE, ResponseMessage.NICKNAME_UNCHANGED);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(result);
    }
}
