package com.ironhack.demosecurityjwt.repositories.profile;

import com.ironhack.demosecurityjwt.models.profile.Enquiry;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class EnquiryRepositoryTest {

    @Autowired
    private EnquiryRepository enquiryRepository;

    @Test
    public void testFindAllByProfileId() {
        Long profileId = 1L;
        List<Enquiry> enquiries = enquiryRepository.findAllByProfileId(profileId);
        Assertions.assertNotNull(enquiries);
        Assertions.assertEquals(0, enquiries.size());
    }
}