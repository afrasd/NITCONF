package io.shraddha;

import io.shraddha.model.ProfileData;
import io.shraddha.repo.ProfileDataRepository;
import io.shraddha.service.ProfileDataService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ProfileDataServiceTest {

    private ProfileDataRepository profileDataRepository;
    private ProfileDataService profileDataService;

    @BeforeEach
    public void setup() {
        profileDataRepository = mock(ProfileDataRepository.class);
        profileDataService = new ProfileDataService(profileDataRepository);
    }

    @Test
    public void testGetAllProfileData() {
        // Create sample profile data
        ProfileData profileData1 = new ProfileData();
        ProfileData profileData2 = new ProfileData();
        List<ProfileData> sampleProfileData = new ArrayList<>();
        sampleProfileData.add(profileData1);
        sampleProfileData.add(profileData2);

        // Stub the behavior of ProfileDataRepository
        when(profileDataRepository.findAll()).thenReturn(sampleProfileData);

        // Call the method to be tested
        List<ProfileData> result = profileDataService.getAllProfileData();

        // Verify that the method returned the expected data
        assertEquals(2, result.size());
    }

    @Test
    public void testGetProfileDataById() {
        // Create sample profile data
        ProfileData profileData = new ProfileData();
        profileData.setId(123L);

        // Stub the behavior of ProfileDataRepository
        when(profileDataRepository.findById(123L)).thenReturn(Optional.of(profileData));

        // Call the method to be tested
        Optional<ProfileData> result = profileDataService.getProfileDataById(123L);

        // Verify that the method returned the expected data
        assertTrue(result.isPresent());
        assertEquals(123L, result.get().getId());
    }

    @Test
    public void testSaveProfileData() {
        // Create sample profile data
        ProfileData profileData = new ProfileData();

        // Stub the behavior of ProfileDataRepository
        when(profileDataRepository.save(profileData)).thenReturn(profileData);

        // Call the method to be tested
        ProfileData result = profileDataService.saveProfileData(profileData);

        // Verify that the method returned the expected data
        assertEquals(profileData, result);
    }

    @Test
    public void testDeleteProfileDataById() {
        // Call the method to be tested
        profileDataService.deleteProfileDataById(123L);

        // Verify that the method was called with the correct parameter
        verify(profileDataRepository, times(1)).deleteById(123L);
    }

    @Test
    public void testDeleteAllProfileData() {
        // Call the method to be tested
        profileDataService.deleteAllProfileData();

        // Verify that the method was called
        verify(profileDataRepository, times(1)).deleteAll();
    }

    @Test
    public void testFindByUsername() {
        // Create sample profile data
        ProfileData profileData = new ProfileData();
        profileData.setUsername("testUser");

        // Stub the behavior of ProfileDataRepository
        when(profileDataRepository.findByUsername("testUser")).thenReturn(profileData);

        // Call the method to be tested
        ProfileData result = profileDataService.findByUsername("testUser");

        // Verify that the method returned the expected data
        assertEquals(profileData, result);
    }
}
