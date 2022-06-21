package com.mars.resume.infrastructure;

import com.mars.resume.domain.Resume;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResumeJpaRepository extends JpaRepository<Resume, Long> {
}
