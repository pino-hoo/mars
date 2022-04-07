package com.mars.common.util;

import com.mars.common.error.ApplicationException;
import com.mars.common.error.ErrorCode;

public class StorageException extends ApplicationException {
    public StorageException(String message) {
        super(message, ErrorCode.INTERNAL_SERVER_ERROR);
    }
}
