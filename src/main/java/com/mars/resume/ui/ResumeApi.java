package com.mars.resume.ui;

import com.mars.common.dto.CommonResponse;
import com.mars.resume.application.ResumeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/resume")
public class ResumeApi {
    private final ResumeService resumeService;

    public ResumeApi(ResumeService resumeService) {
        this.resumeService = resumeService;
    }

    @GetMapping("{id}")
    public CommonResponse<ResumeResponse> findResumeById(@PathVariable(name = "id") Long id) {
        return CommonResponse.success(
                new ResumeResponse(this.resumeService.findResumeById(id)),
                "조회 성공"
        );
    }
}
