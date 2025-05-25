package com.moodiary.moodiary_back.common;

public interface ResponseMessage {

    // HTTP STATUS 200
    String SUCCESS = "성공.";
    String SIGNUP_SUCCESS = "회원가입 성공.";
    String LOGIN_SUCCESS = "로그인 성공.";
    String DELETE_USER_SUCCESS = "회원 삭제 성공.";
    String AUTHORIZATION_SUCCESS = "인증 성공.";



    // HTTP STATUS 400
    String VALIDATION_FAILED = "Validation failed.";

    String DUPLICATE_EMAIL = "이미 가입한 이메일입니다.";

    String SIGNUP_FAIL = "회원가입을 실패하였습니다.";
    String INFORMATION_MISMATCH = "로그인 정보가 일치하지 않습니다.";
    String NICKNAME_UNCHANGED = "기존 닉네임과 같습니다.";
    String PW_MISMATCH = "비밀번호가 정확하지 않습니다.";
    String LOGIN_FAIL = "로그인을 실패하였습니다.";
    String NOT_EXISTED_USER = "회원을 찾을 수 없습니다.";
    String DELETE_USER_FAIL = "회원 삭제를 실패하였습니다.";
    String AUTHORIZATION_FAIL = "인증 실패하였습니다.";



    // HTTP STATUS 500
    String DATABASE_ERROR = "데이터베이스 에러입니다.";

}
