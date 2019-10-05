package com.keirnellyer.glencaldy.menu.option.user;

import com.keirnellyer.glencaldy.manipulation.Manipulator;
import com.keirnellyer.glencaldy.manipulation.property.InputResult;
import com.keirnellyer.glencaldy.manipulation.property.PropertyManager;
import com.keirnellyer.glencaldy.menu.Option;
import com.keirnellyer.glencaldy.repository.UserRepository;
import com.keirnellyer.glencaldy.user.User;

import java.util.Scanner;

public class UserTypeOption extends Option {
    private final PropertyManager propertyManager;
    private final Manipulator<? extends User> manipulator;
    private final UserRepository repository;

    UserTypeOption(UserType type, PropertyManager propertyManager,
                   Manipulator<? extends User> manipulator, UserRepository repository) {
        super(type.toString());
        this.propertyManager = propertyManager;
        this.manipulator = manipulator;
        this.repository = repository;
    }

    @Override
    public void start(Scanner scanner) {
        InputResult result = propertyManager.fetchResult(scanner, false);

        if (result != null) {
            User user = manipulator.create(result);

            if (user != null) {
                repository.add(user);
                System.out.println("New user created successfully.");
            } else {
                System.out.println("Something went wrong whilst creating user.");
            }
        }
    }
}

