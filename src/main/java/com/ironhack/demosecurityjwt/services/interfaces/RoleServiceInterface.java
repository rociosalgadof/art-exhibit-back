package com.ironhack.demosecurityjwt.services.interfaces;

import com.ironhack.demosecurityjwt.models.user.Role;

public interface RoleServiceInterface {
    Role saveRole(Role role);

    void addRoleToUser(String email, String roleName);
}

