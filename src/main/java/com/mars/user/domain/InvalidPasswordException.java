package com.mars.user.domain;

import com.mars.common.error.ApplicationException;
import com.mars.common.error.ErrorCode;

public class InvalidPasswordException extends ApplicationException {
    public InvalidPasswordException() {
        super(ErrorCode.INVALID_PASSWORD);
    }
}
