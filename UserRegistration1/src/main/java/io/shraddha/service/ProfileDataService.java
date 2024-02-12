package io.shraddha.service;

import io.shraddha.model.ProfileData;
import io.shraddha.repo.ProfileDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProfileDataService {

    @Autowired
    private ProfileDataRepository profileDataRepository;

    public List<ProfileData> getAllProfileData() {
        return profileDataRepository.findAll();
    }

    public Optional<ProfileData> getProfileDataById(Long id) {
        return profileDataRepository.findById(id);
    }

    public ProfileData saveProfileData(ProfileData profileData) {
        return profileDataRepository.save(profileData);
    }

    public void deleteProfileDataById(Long id) {
        profileDataRepository.deleteById(id);
    }

    public void deleteAllProfileData() {
        profileDataRepository.deleteAll();
    }
    
    public ProfileData findByUsername(String username) {
        return profileDataRepository.findByUsername(username);
    }
}
