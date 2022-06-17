package com.mars.resume.application;

import com.mars.resume.domain.Resume;
import com.mars.resume.domain.ResumeNotFoundException;
import com.mars.resume.infrastructure.ResumeJpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ResumeService {
    private final ResumeJpaRepository resumeJpaRepository;

    public ResumeService(ResumeJpaRepository resumeJpaRepository) {
        this.resumeJpaRepository = resumeJpaRepository;
    }

    public Resume findResumeById(Long id) {
        return this.resumeJpaRepository.findById(id)
                .orElseThrow(() -> new ResumeNotFoundException());
    }
}
