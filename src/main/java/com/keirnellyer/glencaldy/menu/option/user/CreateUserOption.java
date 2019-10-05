package com.keirnellyer.glencaldy.menu.option.user;

import com.keirnellyer.glencaldy.manipulation.Manipulators;
import com.keirnellyer.glencaldy.manipulation.Manipulator;
import com.keirnellyer.glencaldy.manipulation.property.PropertyManager;
import com.keirnellyer.glencaldy.manipulation.property.InputResult;
import com.keirnellyer.glencaldy.menu.Menu;
import com.keirnellyer.glencaldy.menu.Option;
import com.keirnellyer.glencaldy.repository.UserRepository;
import com.keirnellyer.glencaldy.user.*;

import java.util.Scanner;

import static com.keirnellyer.glencaldy.menu.option.user.UserType.*;

public class CreateUserOption extends Option {
    private final UserRepository repository;

    public CreateUserOption(UserRepository repository) {
        super("Create User");
        this.repository = repository;
    }

    @Override
    public void start(Scanner scanner) {
        Menu menu = new Menu("User Type");
        menu.addItem(new UserTypeOption(CASUAL, Manipulators.CASUAL_MANAGER, Manipulators.CASUAL_MANIPULATOR, repository));
        menu.addItem(new UserTypeOption(FULL, Manipulators.CASUAL_MANAGER, Manipulators.MEMBER_MANIPULATOR, repository));
        menu.addItem(new UserTypeOption(STAFF, Manipulators.STAFF_MANAGER, Manipulators.STAFF_MANIPULATOR, repository));
        menu.addItem(new UserTypeOption(ADMIN, Manipulators.STAFF_MANAGER, Manipulators.ADMINISTRATIVE_MANIPULATOR, repository));
        menu.startMenu(scanner);
    }
}
