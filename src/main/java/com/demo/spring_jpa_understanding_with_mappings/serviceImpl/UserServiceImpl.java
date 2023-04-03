package com.demo.spring_jpa_understanding_with_mappings.serviceImpl;

import com.demo.spring_jpa_understanding_with_mappings.entity.Role;
import com.demo.spring_jpa_understanding_with_mappings.entity.User;
import com.demo.spring_jpa_understanding_with_mappings.repo.RoleRepo;
import com.demo.spring_jpa_understanding_with_mappings.repo.UserRepo;
import com.demo.spring_jpa_understanding_with_mappings.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;
    @Override
    public User createUser (User user) {
        User user1 = this.userRepo.save (user);
        return user1;
    }

    @Override
    public User updateUser (User user,Integer uId , Integer rId) {
        User user1 = this.userRepo.findById (uId).get ();

        Role role = this.roleRepo.findById (rId).get ();

        user1.setuName (user.getuName ());
        user1.setuSurname (user.getuSurname ());
        user1.setEmail (user.getEmail ());
        user1.setRole (role);

        User updatedUser = this.userRepo.save (user1);
        return updatedUser;
    }


    @Override
    public User getUserById (Integer id) {
        User user = this.userRepo.findById (id).get ();
        return user;
    }

    @Override
    public List<User> getAllUsers () {
        List<User> users = this.userRepo.findAll ().stream ().collect (Collectors.toList ());
        return users;
    }

    @Override
    public String deleteUser (Integer id) {
        User user = this.userRepo.findById (id).get ();
        this.userRepo.delete (user);
        return "User deleted successfully";
    }

    @Override
    public User updateUserByRoleName (User user,Integer id,String roleName) {
        User user1 = this.userRepo.findById (id).get ();
        Role byRoleName = this.roleRepo.getByRoleName (roleName);

        user1.setuName (user.getuName ());
        user1.setuSurname (user.getuSurname ());
        user1.setEmail (user.getEmail ());
        user1.setRole (byRoleName);

        User updatedUserByRoleName = this.userRepo.save (user1);
        return updatedUserByRoleName;
    }

    @Override
    public User getUserByRoleId (Integer rId) {
        User userByRoleId = this.userRepo.getUserByRoleId (rId);
        return userByRoleId;
    }
}
