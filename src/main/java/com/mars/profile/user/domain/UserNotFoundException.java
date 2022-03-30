package com.mars.profile.user.domain;

import com.mars.profile.common.error.ApplicationException;
import com.mars.profile.common.error.ErrorCode;

public class UserNotFoundException extends ApplicationException {
    public UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }
}
