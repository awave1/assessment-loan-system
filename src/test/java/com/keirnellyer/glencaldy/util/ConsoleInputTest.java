package com.keirnellyer.glencaldy.util;

import com.keirnellyer.glencaldy.user.Casual;
import com.keirnellyer.glencaldy.user.User;
import com.keirnellyer.glencaldy.user.UserInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Optional;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class ConsoleInputTest {

    ByteArrayInputStream validUserCredentialsInput;
    ByteArrayInputStream invalidUserCredentialsInput;
    ByteArrayInputStream validStringInput;

    @BeforeEach
    void setUp() {
        validUserCredentialsInput = new ByteArrayInputStream("username\npassword\n".getBytes());
        invalidUserCredentialsInput = new ByteArrayInputStream("username\n".getBytes());
        validStringInput = new ByteArrayInputStream("hey there".getBytes());
    }

    @Test
    void shouldGetTheCorrectUser() {
        ConsoleInput<User> input = new ConsoleInput<>();
        input.setScanner(new Scanner(validUserCredentialsInput));
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
        input.setScanner(new Scanner(invalidUserCredentialsInput));
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

    @Test
    void shouldGetCorrectString() {
        ConsoleInput<String> input = new ConsoleInput<>();
        input.setScanner(new Scanner(validStringInput));

        Optional<String> str = input.waitForInput(scanner -> Optional.of(scanner.nextLine()));
        assertTrue(str.isPresent());
        assertEquals("hey there", str.get());
    }

    private Optional<User> getUser(String username, String password) {
        if (username == null || password == null) {
            return Optional.empty();
        }

        User casual = new Casual(new UserInfo().setUsername(username).setPassword(password));
        return Optional.of(casual);
    }
}