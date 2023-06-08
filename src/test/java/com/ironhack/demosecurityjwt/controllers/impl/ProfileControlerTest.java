package com.ironhack.demosecurityjwt.controllers.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.demosecurityjwt.models.profile.Profile;
import com.ironhack.demosecurityjwt.repositories.profile.EnquiryRepository;
import com.ironhack.demosecurityjwt.repositories.profile.ProfileRepository;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.context.WebApplicationContext;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ProfileControlerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProfileRepository profileRepository;

    @MockBean
    private EnquiryRepository enquiryRepository;

    @Test
    public void testGetProfileById() throws Exception {

        long profileId = 1;
        Profile profile = new Profile();
        profile.setId(profileId);
        Optional<Profile> profileOptional = Optional.of(profile);
        Mockito.when(profileRepository.findById(profileId)).thenReturn(profileOptional);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/profile/{id}", profileId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(profileId));
    }

}