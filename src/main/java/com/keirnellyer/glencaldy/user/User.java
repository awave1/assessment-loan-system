package com.keirnellyer.glencaldy.user;

import com.keirnellyer.glencaldy.Session;

import java.util.Objects;

public abstract class User {
    private final String username;
    private String password;
    private Session session = null;
    private UserInfo info = new UserInfo();

    User(String username, String password) {
        this.username = username;
        this.password = password;

        this.info
            .setUsername(username)
            .setPassword(password);
    }

    User(UserInfo info) {
        this.username = info.getUsername();
        this.password = info.getPassword();
        this.info = info;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        this.info.setPassword(password);
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public UserInfo getUserInfo() {
        return info;
    }

    public abstract String getTitle();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(username, user.username) &&
                Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password);
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", session=" + session +
                '}';
    }
}
