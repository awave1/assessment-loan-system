package com.keirnellyer.glencaldy.repository;

import com.keirnellyer.glencaldy.user.User;

public class UserRepository extends Repository<String, User> {
    @Override
    public User get(String username) {
        return this.repoContents
            .stream()
            .filter(item -> item.getUsername().equals(username))
            .findFirst()
            .orElse(null);
    }
}
