package com.mars.project.common.util;

import com.mars.project.common.error.ApplicationException;
import com.mars.project.common.error.ErrorCode;

public class StorageFileNotFoundException extends ApplicationException {

    public StorageFileNotFoundException() {
        super(ErrorCode.STORAGE_FILE_NOT_FOUND);
    }

    public StorageFileNotFoundException(String message) {
        super(message, ErrorCode.STORAGE_FILE_NOT_FOUND);
    }

}
