package com.mars.common.error;

import lombok.Getter;

@Getter
public enum ErrorCode {
    /**
     * COMMON ERROR CODE
     */
    INVALID_INPUT_VALUE(400, "C001", "올바르지 않은 형식입니다."),
    METHOD_NOT_ALLOWED(405, "C002", "지원하지 않는 메소드입니다."),
    ENTITY_NOT_FOUND(400, "C003", "해당 엔티티를 찾을 수가 없습니다."),
    INTERNAL_SERVER_ERROR(500, "C004", "알 수 없는 에러 (서버 에러)"),
    INVALID_TYPE_VALUE(400, "C005", "타입이 올바르지 않습니다."),
    ACCESS_DENIED(403, "C006", "권한이 없습니다."),
    INVALID_TOKEN(401, "C007", "토큰이 올바르지 않습니다."),
    API_CALL_FAILED(500, "C008", "서버 간 통신 중 에러가 발생했습니다."),
    NOT_ACCEPT_IP(400, "C009", "허용하지 않은 IP 입니다"),
    STORAGE_FILE_NOT_FOUND(404, "C010", "존재하지 않는 파일입니다."),
    FAIL_UPLOAD_FILE(404, "C011", "파일 업로드 중 에러가 발생했습니다."),
    UNAUTHORIZED(401, "C012", "인증되지 않은 사용자입니다."),


    /**
     * USER
     */
    INVALID_PASSWORD(400, "U001", "비밀번호가 올바르지 않습니다"),
    USER_NOT_FOUND(400, "U002", "해당 유저가 존재하지 않습니다."),
    DUPLICATED_USERNAME(400, "U003", "중복된 아이디가 존재합니다."),


    /**
     * RESUME
     */
    RESUME_NOT_FOUND(404, "RS001", "존재하지 않는 이력서입니다."),
    ;

    private final int status;
    private final String errorCode;
    private final String message;


    ErrorCode(int status, String errorCode, String message) {
        this.status = status;
        this.errorCode = errorCode;
        this.message = message;
    }
}
