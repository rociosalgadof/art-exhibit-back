package com.ironhack.demosecurityjwt.controllers.impl;

import com.ironhack.demosecurityjwt.models.profile.Enquiry;
import com.ironhack.demosecurityjwt.models.profile.Image;
import com.ironhack.demosecurityjwt.models.profile.Profile;
import com.ironhack.demosecurityjwt.repositories.profile.EnquiryRepository;
import com.ironhack.demosecurityjwt.repositories.profile.ImageRepository;
import com.ironhack.demosecurityjwt.repositories.profile.ParagraphRepository;
import com.ironhack.demosecurityjwt.repositories.profile.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProfileControler {

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private EnquiryRepository enquiryRepository;



    @GetMapping("/profile/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Profile getProductById(@PathVariable(name="id") long profileId) throws Exception{
        Optional<Profile> profileOptional = profileRepository.findById(profileId);
        if(profileOptional.isPresent()){
            return profileRepository.findById(profileId).get();
        }else{
            throw new NoSuchElementException("We couldn't find the element in the Database.");
        }
    }

    @PutMapping("/profile/{id}/edit")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updateProfile(@PathVariable long id, @RequestBody Profile profile) throws Exception{
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication);
        Optional<Profile> profileOptional = profileRepository.findById(id);
        if(profileOptional.isPresent()){
            profile.setId(profileOptional.get().getId());
            profileRepository.save(profile);
        }else{
            throw new NoSuchElementException("We couldn't find the element in the Database.");
        }
    }

    @PostMapping("/profile/{id}/enquiry")
    @ResponseStatus(HttpStatus.CREATED)
    public void addProduct(@PathVariable long id, @RequestBody Enquiry enquiry) throws Exception {
        Optional<Profile> profileOptional = profileRepository.findById(id);
        if(profileOptional.isPresent()){
            enquiry.setProfile(profileOptional.get());
            enquiryRepository.save(enquiry);
        } else{
        throw new NoSuchElementException("We couldn't find the element in the Database.");
    }
    }


}
