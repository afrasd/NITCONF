package io.shraddha;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.shraddha.model.ProfileData;

public class ProfileDataTest {

    private ProfileData profileData;

    @BeforeEach
    public void setUp() {
        profileData = new ProfileData("testUser", "test@example.com", "tag1,tag2");
    }

    @Test
    public void testGettersAndSetters() {
        assertEquals("testUser", profileData.getUsername());
        assertEquals("test@example.com", profileData.getEmailAddress());
        assertEquals("tag1,tag2", profileData.getTags());

        profileData.setUsername("newUser");
        profileData.setEmailAddress("new@example.com");
        profileData.setTags("tag3,tag4");

        assertEquals("newUser", profileData.getUsername());
        assertEquals("new@example.com", profileData.getEmailAddress());
        assertEquals("tag3,tag4", profileData.getTags());
    }

    @Test
    public void testIdGeneration() {
        assertNull(profileData.getId()); // Id should be null before persistence

        // Set Id
        profileData.setId(123L);

        assertEquals(123L, profileData.getId());
    }
}
