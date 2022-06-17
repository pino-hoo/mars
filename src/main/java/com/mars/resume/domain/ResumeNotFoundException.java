package com.mars.resume.domain;

import com.mars.common.error.ApplicationException;
import com.mars.common.error.ErrorCode;

public class ResumeNotFoundException extends ApplicationException {
    public ResumeNotFoundException() {
        super(ErrorCode.RESUME_NOT_FOUND);
    }
}
