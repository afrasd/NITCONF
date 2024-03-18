package io.shraddha;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import io.shraddha.model.ProfileData;
import io.shraddha.repo.ProfileDataRepository;

import org.junit.jupiter.api.Test;

import java.util.Optional;

public class ProfileDataRepositoryTest {

    @Test
    public void testFindByUsername() {
        // Create a mock ProfileDataRepository
        ProfileDataRepository profileDataRepository = mock(ProfileDataRepository.class);

        // Create a sample ProfileData object
        ProfileData sampleProfileData = new ProfileData("testUser", "test@example.com", "tag1,tag2");

        // Stub the behavior of findByUsername method
        when(profileDataRepository.findByUsername("testUser")).thenReturn(sampleProfileData);

        // Call the method to be tested
        ProfileData result = profileDataRepository.findByUsername("testUser");

        // Verify that the method was called with the correct parameter
        verify(profileDataRepository, times(1)).findByUsername("testUser");

        // Verify that the returned value matches the expected ProfileData object
        assertEquals("test@example.com", result.getEmailAddress());
        assertEquals("tag1,tag2", result.getTags());
    }
}
