package com.ironhack.demosecurityjwt.repositories.profile;

import com.ironhack.demosecurityjwt.models.profile.Project;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProjectRepositoryTest {

    @Autowired
    private ProjectRepository projectRepository;

    @Test
    public void testSaveAndFindById() {
        Project project = new Project();
        Project savedProject = projectRepository.save(project);
        Project foundProject = projectRepository.findById(savedProject.getId()).orElse(null);
        Assertions.assertNotNull(foundProject);
    }
}