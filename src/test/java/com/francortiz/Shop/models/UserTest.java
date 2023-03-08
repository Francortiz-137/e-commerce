package com.francortiz.Shop.models;

import com.francortiz.Shop.exceptions.InvalidEmailException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    User user;

    @BeforeEach
    void setUp() {
        this.user = new User();
    }


    @Test
    void test_email_user() {
        user.setEmail("johnDoe@example.com");

        assertEquals("johnDoe@example.com",user.getEmail());
        //assertThrows(InvalidEmailException.class,() -> user.setEmail(""));
    }
}