package com.mars.project.common.dto;

import com.mars.project.common.error.ErrorCode;
import lombok.Getter;
import org.springframework.validation.BindingResult;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ErrorResponse {

    private final String message;
    private final int status;
    private final String errorCode;
    private final List<FieldError> errors;

    private ErrorResponse(ErrorCode errorCode, List<FieldError> fieldErrors) {
        this.message = errorCode.getMessage();
        this.status = errorCode.getStatus();
        this.errorCode = errorCode.getErrorCode();
        this.errors = fieldErrors;
    }

    public static ErrorResponse of(final ErrorCode errorCode, final BindingResult bindingResult) {
        return new ErrorResponse(errorCode, FieldError.of(bindingResult));
    }

    public static ErrorResponse of(final ErrorCode code) {
        return new ErrorResponse(code, null);
    }

    public static ErrorResponse of(MethodArgumentTypeMismatchException e) {
        final String value = e.getValue() == null ? "" : e.getValue().toString();
        final List<FieldError> errors = FieldError.of(e.getName(), value, e.getErrorCode());
        return new ErrorResponse(ErrorCode.INVALID_TYPE_VALUE, errors);
    }


    @Getter
    public static class FieldError {
        private String field;
        private String value;
        private String cause;

        private FieldError() {

        }

        private FieldError(String field, String value, String cause) {
            this.field = field;
            this.value = value;
            this.cause = cause;
        }

        public static List<FieldError> of(final String field, final String value, final String cause) {
            return List.of(new FieldError(field, value, cause));
        }

        public static List<FieldError> of(final BindingResult bindingResult) {
            final List<org.springframework.validation.FieldError> fieldErrors = bindingResult.getFieldErrors();
            return fieldErrors.stream()
                    .map(error -> new FieldError(
                            error.getField(),
                            error.getRejectedValue() != null ? error.getRejectedValue().toString() : "",
                            error.getDefaultMessage()))
                    .collect(Collectors.toList());
        }
    }
}

