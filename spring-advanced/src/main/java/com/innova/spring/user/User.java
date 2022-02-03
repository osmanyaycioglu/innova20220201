package com.innova.spring.user;

import java.time.LocalDate;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "kullanici")
public class User {

    @Id
    @GeneratedValue
    private Long            userId;
    @NotNull
    @Convert(converter = EncryptedStringConverter.class)
    private EncryptedString username;
    @NotNull
    @Convert(converter = EncryptedStringConverter.class)
    private EncryptedString password;
    private LocalDate       createDate;
    @Enumerated(EnumType.STRING)
    private ERole           role;

    @Transient
    private String          clearPassword;

    @PrePersist
    @PreUpdate
    public void preWrite() {
        // encrypt
    }

    @PostUpdate
    @PostPersist
    @PostLoad
    public void postLoad() {
        // decrypt
    }


    public LocalDate getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(final LocalDate createDateParam) {
        this.createDate = createDateParam;
    }

    public ERole getRole() {
        return this.role;
    }

    public void setRole(final ERole roleParam) {
        this.role = roleParam;
    }

    public String getClearPassword() {
        return this.clearPassword;
    }

    public void setClearPassword(final String clearPasswordParam) {
        this.clearPassword = clearPasswordParam;
    }


    public Long getUserId() {
        return this.userId;
    }


    public void setUserId(final Long userIdParam) {
        this.userId = userIdParam;
    }


    public EncryptedString getUsername() {
        return this.username;
    }


    public void setUsername(final EncryptedString usernameParam) {
        this.username = usernameParam;
    }


    public EncryptedString getPassword() {
        return this.password;
    }


    public void setPassword(final EncryptedString passwordParam) {
        this.password = passwordParam;
    }


}
