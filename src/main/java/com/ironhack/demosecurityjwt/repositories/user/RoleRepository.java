package com.ironhack.demosecurityjwt.repositories.user;

import com.ironhack.demosecurityjwt.models.user.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The RoleRepository interface extends JpaRepository to allow for CRUD operations
 * on Role entities in the database.
 */
@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByName(String name);
}

