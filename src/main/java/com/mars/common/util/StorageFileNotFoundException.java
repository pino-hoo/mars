package com.mars.common.util;

import com.mars.common.error.ApplicationException;
import com.mars.common.error.ErrorCode;

public class StorageFileNotFoundException extends ApplicationException {

    public StorageFileNotFoundException() {
        super(ErrorCode.STORAGE_FILE_NOT_FOUND);
    }

    public StorageFileNotFoundException(String message) {
        super(message, ErrorCode.STORAGE_FILE_NOT_FOUND);
    }

}
