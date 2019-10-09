package com.keirnellyer.glencaldy.util;

import com.keirnellyer.glencaldy.user.Casual;
import com.keirnellyer.glencaldy.user.User;
import com.keirnellyer.glencaldy.user.UserInfo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Optional;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class ConsoleInputTest {

    ByteArrayInputStream validInput;
    ByteArrayInputStream invalidInput;

    @BeforeEach
    void setUp() {
        validInput = new ByteArrayInputStream("username\npassword\n".getBytes());
        invalidInput = new ByteArrayInputStream("username\n".getBytes());
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void shouldGetTheCorrectInput() {
        ConsoleInput<User> input = new ConsoleInput<>();
        input.setScanner(new Scanner(validInput));
        Optional<User> user = input.waitForInput(scanner -> {
            String username = scanner.nextLine();
            String password = scanner.nextLine();
            return getUser(username, password);
        });

        assertTrue(user.isPresent());
        assertEquals("username", user.get().getUsername());
        assertEquals("password", user.get().getPassword());
    }

    @Test
    void shouldNotGetUserObject() {
        ConsoleInput<User> input = new ConsoleInput<>();
        input.setScanner(new Scanner(invalidInput));
        Optional<User> user = input.waitForInput(scanner -> {
            if (scanner.hasNext()) {
                String username = scanner.nextLine();

                return getUser(username, null);
            } else {
                scanner.close();
            }

            return Optional.empty();
        });

        assertFalse(user.isPresent());
    }

    private Optional<User> getUser(String username, String password) {
        if (username == null || password == null) {
            return Optional.empty();
        }

        User casual = new Casual(new UserInfo().setUsername(username).setPassword(password));
        return Optional.of(casual);
    }
}