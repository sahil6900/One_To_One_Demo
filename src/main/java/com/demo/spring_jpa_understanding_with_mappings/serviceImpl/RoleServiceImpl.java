package com.demo.spring_jpa_understanding_with_mappings.serviceImpl;

import com.demo.spring_jpa_understanding_with_mappings.entity.Role;
import com.demo.spring_jpa_understanding_with_mappings.repo.RoleRepo;
import com.demo.spring_jpa_understanding_with_mappings.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepo roleRepo;
    @Override
    public Role createRole (Role role) {
        Role role1 = this.roleRepo.save (role);
        return role;
    }

    @Override
    public Role updateRole (Integer id , Role role) {
        Role role1 = this.roleRepo.findById (id).get ();
        role1.setRoleName (role.getRoleName ());
        role1.setUser (role.getUser ());

        Role updatedRole = this.roleRepo.save (role1);
        return updatedRole;
    }

    @Override
    public Role getRoleById (Integer id) {
        Role role = this.roleRepo.findById (id).get ();
        return role;
    }

    @Override
    public List<Role> getAllRoles () {
        List<Role> allRoles = this.roleRepo.findAll ();
        return allRoles;
    }

    @Override
    public String deleteRole (Integer id) {
        Role role = this.roleRepo.findById (id).get ();

        this.roleRepo.delete (role);

        return "Role deleted succesfully";
    }
}
