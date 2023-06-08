package com.ironhack.demosecurityjwt.repositories.profile;

import com.ironhack.demosecurityjwt.models.profile.Profile;
import com.ironhack.demosecurityjwt.models.user.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {

}
