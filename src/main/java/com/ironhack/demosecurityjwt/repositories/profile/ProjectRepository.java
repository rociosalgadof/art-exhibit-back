package com.ironhack.demosecurityjwt.repositories.profile;

import com.ironhack.demosecurityjwt.models.profile.Home;
import com.ironhack.demosecurityjwt.models.profile.Project;
import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

}
