package com.keirnellyer.glencaldy.user;

import java.time.LocalDate;

public class UserInfo {
    private String username;
    private String password;
    private LocalDate birthDate;
    private String phoneNumber;
    private String address;
    private int staffId;
    private String email;
    private String extension;

    public String getUsername() {
        return username;
    }

    public UserInfo setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserInfo setPassword(String password) {
        this.password = password;
        return this;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public UserInfo setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public UserInfo setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public UserInfo setAddress(String address) {
        this.address = address;
        return this;
    }

    public int getStaffId() {
        return staffId;
    }

    public UserInfo setStaffId(int staffId) {
        this.staffId = staffId;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserInfo setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getExtension() {
        return extension;
    }

    public UserInfo setExtension(String extension) {
        this.extension = extension;
        return this;
    }
}
