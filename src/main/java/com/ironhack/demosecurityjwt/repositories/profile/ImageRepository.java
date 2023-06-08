package com.ironhack.demosecurityjwt.repositories.profile;

import com.ironhack.demosecurityjwt.models.profile.Image;
import com.ironhack.demosecurityjwt.models.profile.Paragraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {

}
