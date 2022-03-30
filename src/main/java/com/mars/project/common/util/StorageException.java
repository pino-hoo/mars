package com.mars.project.common.util;

import com.mars.project.common.error.ApplicationException;
import com.mars.project.common.error.ErrorCode;

public class StorageException extends ApplicationException {


    public StorageException(String message) {
        super(message, ErrorCode.INTERNAL_SERVER_ERROR);
    }
}
