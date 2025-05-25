package com.moodiary.moodiary_back.dto.response;

import com.moodiary.moodiary_back.common.ResponseCode;
import com.moodiary.moodiary_back.common.ResponseMessage;
import com.moodiary.moodiary_back.dto.ResponseDto;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
public class ChangePWResponseDto extends ResponseDto {
    public ChangePWResponseDto() {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);}

    public static ResponseEntity<ChangePWResponseDto> success() {
        ChangePWResponseDto result = new ChangePWResponseDto();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    public static ResponseEntity<ResponseDto> fail() {
        ResponseDto result = new ResponseDto(ResponseCode.SEND_TOAST_MESSAGE, ResponseMessage.PW_MISMATCH);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(result);
    }
}
