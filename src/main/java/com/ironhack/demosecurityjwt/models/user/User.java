package com.ironhack.demosecurityjwt.models.user;

import com.ironhack.demosecurityjwt.models.profile.Profile;
import com.ironhack.demosecurityjwt.models.user.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;

import static jakarta.persistence.FetchType.EAGER;

/**
 * Entity class for representing a User in the database
 */
@Entity
@Data
@AllArgsConstructor
public class User {
    /**
     * The unique identifier for the user
     */
    @Id
    /**
     * The id field is generated automatically by the database
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * The name of the user
     */
    private String name;

    /**
     * The username used to log in
     */
    private String username;

    /**
     * The password used to log in
     */
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    private Profile profile;

    /**
     * The roles that the user has
     */
    @ManyToMany(fetch = EAGER)
    private Collection<Role> roles = new ArrayList<>();

    public User() {
    }

    public User(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.profile = new Profile();
    }
}
