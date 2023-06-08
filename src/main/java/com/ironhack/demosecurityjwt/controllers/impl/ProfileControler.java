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
    public Profile getProfileById(@PathVariable(name="id") long profileId) throws Exception{
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

    @GetMapping("/profile/{id}/enquiry")
    @ResponseStatus(HttpStatus.OK)
    public List<Enquiry> getAllEnquiries(@PathVariable(name="id") long profileId) throws Exception{
        Optional<Profile> profileOptional = profileRepository.findById(profileId);
        System.out.println("inside get all enquiries route");
        if(profileOptional.isPresent()){
            System.out.println("inside get all enquiries route");
            return enquiryRepository.findAllByProfileId(profileId);
        }else{
            throw new NoSuchElementException("We couldn't find the element in the Database.");
        }
    }

    @DeleteMapping("/profile/{profileId}/enquiry/{enquiryId}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteEnquiry(@PathVariable("profileId") Long profileId, @PathVariable("enquiryId") Long enquiryId) throws Exception{
        Optional<Enquiry> optionalEnquiry = enquiryRepository.findById(enquiryId);
        if(optionalEnquiry.isPresent()){
            optionalEnquiry.get().setProfile(null);
            enquiryRepository.save(optionalEnquiry.get());
            enquiryRepository.deleteById(enquiryId);
        }else{
            throw new NoSuchElementException("We couldn't find the element in the Database.");
        }
    }


}
