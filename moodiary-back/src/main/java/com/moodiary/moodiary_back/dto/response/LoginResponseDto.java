package com.moodiary.moodiary_back.dto.response;

import com.moodiary.moodiary_back.common.ResponseCode;
import com.moodiary.moodiary_back.common.ResponseMessage;
import com.moodiary.moodiary_back.dto.ResponseDto;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
public class LoginResponseDto extends ResponseDto {
    private String access;
    private String refresh;

    public LoginResponseDto(String access, String refresh) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.access = access;
        this.refresh = refresh;
    }
    public static ResponseEntity<LoginResponseDto> success(String access, String refresh, HttpServletResponse response) {
        LoginResponseDto result = new LoginResponseDto(access, refresh);

        return ResponseEntity.status(HttpStatus.OK)
                .body(result);
    }
    public static ResponseEntity<ResponseDto> signInFail() {
        ResponseDto result = new ResponseDto(ResponseCode.SEND_TOAST_MESSAGE, ResponseMessage.INFORMATION_MISMATCH);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(result);
    }
}
