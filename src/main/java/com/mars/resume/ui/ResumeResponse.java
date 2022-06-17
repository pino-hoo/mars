package com.mars.resume.ui;

import com.mars.resume.domain.Address;
import com.mars.resume.domain.Resume;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class ResumeResponse {
    private Long id;
    private Long memberId;
    private String introduce;
    private Address address;
    private String email;
    private LocalDate birthDate;
    private String phone;
    private String name;

    public ResumeResponse(Resume resume) {
        this.id = resume.getId();
        this.memberId = resume.getMemberId();
        this.introduce = resume.getIntroduce();
        this.address = resume.getAddress();
        this.email = resume.getEmail();
        this.birthDate = resume.getBirthDate();
        this.phone = resume.getPhone();
        this.name = resume.getName();
    }
}
