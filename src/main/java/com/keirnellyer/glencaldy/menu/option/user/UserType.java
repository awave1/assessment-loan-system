package com.keirnellyer.glencaldy.menu.option.user;


public enum UserType {
    CASUAL("Casual"),
    FULL("Full"),
    STAFF("Staff"),
    ADMIN("Administrative");

    private String type;

    UserType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return this.type;
    }
}
