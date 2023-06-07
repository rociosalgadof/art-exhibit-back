package com.ironhack.demosecurityjwt.services.interfaces;

import com.ironhack.demosecurityjwt.models.user.Role;
import com.ironhack.demosecurityjwt.models.user.User;

import java.util.List;

/**
 * The UserServiceInterface is an interface that defines the methods that are available to perform operations on User entities.
 */
public interface UserServiceInterface {
    User saveUser(User userSignupDTO);

    List<User> getUsers();
}


