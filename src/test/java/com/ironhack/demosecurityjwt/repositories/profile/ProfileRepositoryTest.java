package com.ironhack.demosecurityjwt.repositories.profile;

import com.ironhack.demosecurityjwt.models.profile.Profile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class ProfileRepositoryTest {

    @Autowired
    private ProfileRepository profileRepository;

    @Test
    public void testSaveAndFindById() {
        Profile profile = new Profile();
        Profile savedProfile = profileRepository.save(profile);
        Profile foundProfile = profileRepository.findById(savedProfile.getId()).orElse(null);
        Assertions.assertNotNull(foundProfile);
    }
}