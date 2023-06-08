package com.ironhack.demosecurityjwt.repositories.profile;

import com.ironhack.demosecurityjwt.models.profile.Enquiry;
import com.ironhack.demosecurityjwt.models.profile.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnquiryRepository extends JpaRepository<Enquiry, Long> {
    @Query("SELECT e FROM Enquiry e JOIN e.profile p WHERE p.id = :profileId")
    List<Enquiry> findAllByProfileId(@Param("profileId") Long profileId);
}
