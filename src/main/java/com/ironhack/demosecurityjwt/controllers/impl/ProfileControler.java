package com.ironhack.demosecurityjwt.controllers.impl;

import com.ironhack.demosecurityjwt.models.profile.Image;
import com.ironhack.demosecurityjwt.models.profile.Profile;
import com.ironhack.demosecurityjwt.repositories.profile.ImageRepository;
import com.ironhack.demosecurityjwt.repositories.profile.ParagraphRepository;
import com.ironhack.demosecurityjwt.repositories.profile.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProfileControler {

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private ParagraphRepository paragraphRepository;

    @Autowired
    private ImageRepository imageRepository;

    @GetMapping("/profile/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Profile getProductById(@PathVariable(name="id") long profileId) {
        return profileRepository.findById(profileId).get();
    }

    @PutMapping("/profile/{id}/edit")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updateProfile(@PathVariable long id, @RequestBody Profile profile) {
        Optional<Profile> profileOptional = profileRepository.findById(id);
        profile.setId(profileOptional.get().getId());
        profileRepository.save(profile);
    }

    @DeleteMapping("/profile/{id}/about/{paragraphId}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id, @PathVariable("paragraphId") Long paragraphId) {
        Optional<Profile> profileOptional = profileRepository.findById(id);
        paragraphRepository.deleteById(paragraphId);
    }


}
