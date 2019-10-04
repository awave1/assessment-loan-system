package com.keirnellyer.glencaldy.repository;

import com.keirnellyer.glencaldy.user.Casual;
import com.keirnellyer.glencaldy.user.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest {
    private static ArrayList<User> users = new ArrayList<>();

    @BeforeAll
    static void beforeAll() {
        LocalDate date = LocalDate.now();
        for (int i = 0; i < 5; i++) {
            Casual casualUser = new Casual(
                "user " + i,
                "password " + i,
                "address " + i,
                "phone num " + i,
                date
            );

            users.add(casualUser);
        }
    }

    @Test
    void shouldContainNoItems() {
        UserRepository stock = new UserRepository();
        assertNotNull(stock.getAll());
        assertEquals(0, stock.getAll().size());
    }

    @Test
    void shouldAddSingleItem() {
        UserRepository userRepo = new UserRepository();

        // Add a user
        userRepo.add(users.get(0));
        String username = users.get(0).getUsername();

        assertNotNull(userRepo.getAll());
        assertEquals(1, userRepo.getAll().size());

        Casual actualUser = (Casual) userRepo.get(username);

        assertNotNull(actualUser);
        assertEquals(username, actualUser.getUsername());
    }

    @Test
    void shouldAddManyItems() {
        UserRepository userRepo = new UserRepository();

        // Add a user
        users.forEach(userRepo::add);

        assertNotNull(userRepo.getAll());
        assertEquals(users.size(), userRepo.getAll().size());

        users.forEach(user -> {
            Casual actualUser = (Casual) userRepo.get(user.getUsername());

            assertNotNull(actualUser);
            assertEquals(user.getUsername(), actualUser.getUsername());
        });

    }

    @Test
    void shouldGetUserByUsernameAndPassword() {
        UserRepository userRepo = new UserRepository();

        // Add a user
        userRepo.add(users.get(0));
        String username = users.get(0).getUsername();
        String password = users.get(0).getPassword();

        User user = userRepo.getExact(username, password);

        assertNotNull(user);
        assertEquals(username, user.getUsername());
        assertEquals(password, user.getPassword());
    }
}
