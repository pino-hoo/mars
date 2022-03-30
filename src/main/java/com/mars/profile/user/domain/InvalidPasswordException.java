package com.mars.profile.user.domain;

import com.mars.profile.common.error.ApplicationException;
import com.mars.profile.common.error.ErrorCode;

public class InvalidPasswordException extends ApplicationException {
    public InvalidPasswordException() {
        super(ErrorCode.INVALID_PASSWORD);
    }
}
