package com.keirnellyer.glencaldy.user;

import java.time.LocalDate;
import java.util.Objects;

public class Casual extends User {
    private String address;
    private String phoneNumber;
    private LocalDate birthDate;

    public Casual(String username, String password, String address, String phoneNumber, LocalDate birthDate) {
        super(username, password);
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
    }

    public Casual(UserInfo info) {
        super(info);
        this.address = info.getAddress();
        this.phoneNumber = info.getPhoneNumber();
        this.birthDate = info.getBirthDate();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
        getUserInfo().setAddress(address);
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        getUserInfo().setPhoneNumber(phoneNumber);
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        getUserInfo().setBirthDate(birthDate);
    }

    @Override
    public String getTitle() {
        return "Casual User";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Casual)) return false;
        if (!super.equals(o)) return false;
        Casual casual = (Casual) o;
        return Objects.equals(address, casual.address) &&
                Objects.equals(phoneNumber, casual.phoneNumber) &&
                Objects.equals(birthDate, casual.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), address, phoneNumber, birthDate);
    }

    @Override
    public String toString() {
        return "Casual{" +
                "address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", birthDate=" + birthDate +
                "} " + super.toString();
    }
}
