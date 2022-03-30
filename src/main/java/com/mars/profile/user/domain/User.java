package com.mars.profile.user.domain;

import com.mars.profile.common.entity.BaseTimeEntity;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Getter
@Table(name = "tbl_user")
public class User extends BaseTimeEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;


    @ElementCollection(fetch = FetchType.EAGER, targetClass = Role.class)
    @CollectionTable(name = "tbl_user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private Set<Role> roles = new LinkedHashSet<>();

    @Enumerated(EnumType.STRING)
    private UserStatus status;

    protected User() {
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getRole()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.status.isActive();
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.status.isActive();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.status.isActive();
    }

    @Override
    public boolean isEnabled() {
        return this.status.isActive();
    }


    public void initPassword(PasswordEncoder passwordEncoder, String password) {
        String encodePassword = passwordEncoder.encode(password);
        this.password = encodePassword;
    }

    public void validatePasswordMatch(PasswordEncoder passwordEncoder, String rawPassword) {
        if (!passwordEncoder.matches(rawPassword, this.password)) {
            throw new InvalidPasswordException();
        }
    }


}
