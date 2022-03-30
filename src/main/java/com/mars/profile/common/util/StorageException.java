package com.mars.profile.common.util;

import com.mars.profile.common.error.ApplicationException;
import com.mars.profile.common.error.ErrorCode;

public class StorageException extends ApplicationException {


    public StorageException(String message) {
        super(message, ErrorCode.INTERNAL_SERVER_ERROR);
    }
}
