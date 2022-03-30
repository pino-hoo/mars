package com.mars.project.user.domain;

import com.mars.project.common.error.ApplicationException;
import com.mars.project.common.error.ErrorCode;

public class UserNotFoundException extends ApplicationException {
    public UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }
}
