package com.ironhack.demosecurityjwt.repositories.user;

import com.ironhack.demosecurityjwt.models.user.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import com.ironhack.demosecurityjwt.services.impl.UserService;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    @Test
    public void create_new_user(){
        User rocio = new User("Rocio", "rociosalgado", "1234");
        userRepository.save(rocio);

        assertTrue(true);
    }

    @Test
    void findByUsername() {
    }
}