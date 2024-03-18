package io.shraddha;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.shraddha.model.User;

public class UserTest {

    private User user;

    @BeforeEach
    public void setUp() {
        user = new User();
    }

    @Test
    public void testGettersAndSetters() {
        user.setUser_id(123);
        assertEquals(123, user.getUser_id());

        user.setUser_fname("John");
        assertEquals("John", user.getUser_fname());

        user.setUser_lname("Doe");
        assertEquals("Doe", user.getUser_lname());

        user.setUser_email("john@example.com");
        assertEquals("john@example.com", user.getUser_email());

        user.setUser_pass("password123");
        assertEquals("password123", user.getUser_pass());

        user.setUser_mobile("1234567890");
        assertEquals("1234567890", user.getUser_mobile());
    }

    @Test
    public void testToString() {
        user.setUser_id(123);
        user.setUser_fname("John");
        user.setUser_lname("Doe");
        user.setUser_email("john@example.com");
        user.setUser_pass("password123");
        user.setUser_mobile("1234567890");

        String expectedString = "User [id=123, user_fname=John, user_lname=Doe, user_email=john@example.com, user_pass=password123, user_mobile=1234567890]";

        assertEquals(expectedString, user.toString());
    }
}
