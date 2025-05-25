package com.moodiary.moodiary_back.dto.response;

import com.moodiary.moodiary_back.common.ResponseCode;
import com.moodiary.moodiary_back.common.ResponseMessage;
import com.moodiary.moodiary_back.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class SignUpResponseDto extends ResponseDto {

    public SignUpResponseDto() { super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);}

    public static ResponseEntity<SignUpResponseDto> success() {
        SignUpResponseDto result = new SignUpResponseDto();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public static ResponseEntity<ResponseDto> duplicateEmail() {
        ResponseDto result = new ResponseDto(ResponseCode.SEND_TOAST_MESSAGE, ResponseMessage.DUPLICATE_EMAIL);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }
}
