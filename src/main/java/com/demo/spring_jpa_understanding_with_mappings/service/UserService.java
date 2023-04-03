package com.demo.spring_jpa_understanding_with_mappings.service;

import com.demo.spring_jpa_understanding_with_mappings.entity.User;

import java.util.List;

public interface UserService {
    public User createUser(User user);

    public User updateUser(User user,Integer uId,Integer rId);

    public User getUserById(Integer id);

    public List<User> getAllUsers();

    public String deleteUser(Integer id);

    public User updateUserByRoleName(User user,Integer id,String roleName);

    public User getUserByRoleId(Integer rId);
}
