package com.example.elgrande.service.role_service;

import com.example.elgrande.model.role.Role;

import java.util.List;

public interface RoleService {
    void insertRole(Role role);
    List<Role> getRoles();
    Role findRoleByName(String roleName);
}
