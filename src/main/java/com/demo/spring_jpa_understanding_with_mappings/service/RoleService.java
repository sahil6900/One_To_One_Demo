package com.demo.spring_jpa_understanding_with_mappings.service;

import com.demo.spring_jpa_understanding_with_mappings.entity.Role;

import java.util.List;

public interface RoleService {

    public Role createRole(Role role);

    public Role updateRole(Integer id,Role role);

    public Role getRoleById(Integer id);

    public List<Role> getAllRoles();

    public String deleteRole(Integer id);
}
