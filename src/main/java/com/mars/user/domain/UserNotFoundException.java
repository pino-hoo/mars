package com.mars.user.domain;

import com.mars.common.error.ApplicationException;
import com.mars.common.error.ErrorCode;

public class UserNotFoundException extends ApplicationException {
    public UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }
}
