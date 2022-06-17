package com.mars.resume.domain;


import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tbl_resume")
@Getter
public class Resume {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "resume_id")
    private Long id;

    private Long memberId;

    private String introduce;

    @Embedded
    private Address address;

    private String email;
    private LocalDate birthDate;
    private String phone;
    private String name;

    protected Resume() {
    }

    @Builder
    public Resume(Long id, Long memberId, String introduce, Address address, String email, LocalDate birthDate, String phone, String name) {
        this.id = id;
        this.memberId = memberId;
        this.introduce = introduce;
        this.address = address;
        this.email = email;
        this.birthDate = birthDate;
        this.phone = phone;
        this.name = name;
    }

    public static Resume create(Long memberId, String introduce, Address address, String email, LocalDate birthDate, String phone, String name) {
        return new Resume(memberId, introduce, new Address(address.getPostcode(), address.getAddress(), address.getDetailAddress()), email, birthDate, phone, name);
    }

    private Resume(Long memberId, String introduce, Address address, String email, LocalDate birthDate, String phone, String name) {
        this.memberId = memberId;
        this.introduce = introduce;
        this.address = address;
        this.email = email;
        this.birthDate = birthDate;
        this.phone = phone;
        this.name = name;
    }
}
