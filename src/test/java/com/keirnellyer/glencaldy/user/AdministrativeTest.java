package com.keirnellyer.glencaldy.user;


import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class AdministrativeTest {
    @Test
    void shouldCreateAdministrativeObjectUsingUserInfo() {
        UserInfo userInfo = new UserInfo();
        userInfo
            .setUsername("user")
            .setPassword("pass")
            .setAddress("addr")
            .setPhoneNumber("1243")
            .setBirthDate(LocalDate.of(2019, 3, 3))
            .setStaffId(1)
            .setEmail("email@email.com")
            .setExtension("ext");

        assertNotNull(userInfo);

        Administrative admin = new Administrative(userInfo);

        assertNotNull(admin);
        assertEquals(userInfo, admin.getUserInfo());
    }

    @Test
    void shouldSetExtensionAndUpdateUserInfo() {
        UserInfo userInfo = new UserInfo();
        userInfo
                .setUsername("user")
                .setPassword("pass")
                .setAddress("addr")
                .setPhoneNumber("1243")
                .setBirthDate(LocalDate.of(2019, 3, 3))
                .setStaffId(1)
                .setEmail("email@email.com")
                .setExtension("ext");

        assertNotNull(userInfo);

        Administrative admin = new Administrative(userInfo);

        assertNotNull(admin);
        assertEquals(userInfo, admin.getUserInfo());

        admin.setExtension("ext2");
        assertEquals(userInfo, admin.getUserInfo());
    }

    @Test
    void shouldSetEmailAndUpdateUserInfo() {
        UserInfo userInfo = new UserInfo();
        userInfo
                .setUsername("user")
                .setPassword("pass")
                .setAddress("addr")
                .setPhoneNumber("1243")
                .setBirthDate(LocalDate.of(2019, 3, 3))
                .setStaffId(1)
                .setEmail("email@email.com")
                .setExtension("ext");

        assertNotNull(userInfo);

        Administrative admin = new Administrative(userInfo);

        assertNotNull(admin);
        assertEquals(userInfo, admin.getUserInfo());

        admin.setEmail("email2@email.com");
        assertEquals(userInfo, admin.getUserInfo());
    }
}