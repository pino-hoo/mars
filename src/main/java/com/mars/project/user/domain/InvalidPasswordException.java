package com.mars.project.user.domain;

import com.mars.project.common.error.ApplicationException;
import com.mars.project.common.error.ErrorCode;

public class InvalidPasswordException extends ApplicationException {
    public InvalidPasswordException() {
        super(ErrorCode.INVALID_PASSWORD);
    }
}
