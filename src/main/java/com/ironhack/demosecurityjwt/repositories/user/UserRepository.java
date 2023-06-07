package com.ironhack.demosecurityjwt.repositories.user;

import com.ironhack.demosecurityjwt.models.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The UserRepository interface extends JpaRepository to allow for CRUD operations
 * on User entities in the database.
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);
}
