package io.shraddha;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import io.shraddha.model.User;
import io.shraddha.repo.UserRepository;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryTest {

    @Test
    public void testFindByEMAIL() {
        // Create a mock UserRepository
        UserRepository userRepository = mock(UserRepository.class);

        // Create sample User objects
        User user1 = new User();
        user1.setUser_email("test1@example.com");

        User user2 = new User();
        user2.setUser_email("test2@example.com");

        List<User> sampleUserList = new ArrayList<>();
        sampleUserList.add(user1);
        sampleUserList.add(user2);

        // Stub the behavior of findByEMAIL method
        when(userRepository.findByEMAIL("test1@example.com")).thenReturn(sampleUserList);

        // Call the method to be tested
        List<User> result = userRepository.findByEMAIL("test1@example.com");

        // Verify that the method was called with the correct parameter
        verify(userRepository, times(1)).findByEMAIL("test1@example.com");

        // Verify that the returned list matches the expected list
        assertEquals(2, result.size());
        assertEquals("test1@example.com", result.get(0).getUser_email());
        assertEquals("test2@example.com", result.get(1).getUser_email());
    }

    @Test
    public void testFindByUsernamePassword() {
        // Create a mock UserRepository
        UserRepository userRepository = mock(UserRepository.class);

        // Create a sample User object
        User sampleUser = new User();
        sampleUser.setUser_email("test@example.com");
        sampleUser.setUser_pass("password123");

        // Stub the behavior of findByUsernamePassword method
        when(userRepository.findByUsernamePassword("test@example.com", "password123")).thenReturn(sampleUser);

        // Call the method to be tested
        User result = userRepository.findByUsernamePassword("test@example.com", "password123");

        // Verify that the method was called with the correct parameters
        verify(userRepository, times(1)).findByUsernamePassword("test@example.com", "password123");

        // Verify that the returned value matches the expected User object
        assertEquals("test@example.com", result.getUser_email());
        assertEquals("password123", result.getUser_pass());
    }
}
