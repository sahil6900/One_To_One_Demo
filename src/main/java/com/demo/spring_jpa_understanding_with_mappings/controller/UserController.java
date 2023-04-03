package com.demo.spring_jpa_understanding_with_mappings.controller;

import com.demo.spring_jpa_understanding_with_mappings.entity.User;
import com.demo.spring_jpa_understanding_with_mappings.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

   final static Logger logger = LoggerFactory.getLogger (UserController.class);
    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user){
        logger.info ("createUser method",user);
        User createdUser1 = this.userService.createUser (user);
        logger.debug ("end of createUser method",createdUser1);
        return new ResponseEntity<User> (createdUser1, HttpStatus.CREATED);
    }

    @PutMapping("/update/{uId}/{rId}")
    public ResponseEntity<User> updateUser(@RequestBody User user,@PathVariable Integer uId,@PathVariable Integer rId ){
        User updatedUser = this.userService.updateUser (user,uId ,rId);

        return new ResponseEntity<User> (updatedUser,HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Integer id){
        User userById = this.userService.getUserById (id);

        return new ResponseEntity<User> (userById,HttpStatus.OK);
    }

    @GetMapping("/all/users")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> allUsers = this.userService.getAllUsers ();

        return new ResponseEntity<List<User>> (allUsers,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer id){
        String s = this.userService.deleteUser (id);

        return new ResponseEntity<String> (s,HttpStatus.OK);
    }

    @PutMapping("/update/by/role/name/{name}/{uId}")
    public ResponseEntity<User> updateUserByRoleName(@RequestBody User user,@PathVariable Integer uId,@PathVariable String name){
        User updateUserByRoleName = this.userService.updateUserByRoleName (user , uId , name);

        return new ResponseEntity<User> (updateUserByRoleName,HttpStatus.OK);
    }

    @GetMapping("/get/user/by/roleId/{rId}")
    public ResponseEntity<User> getUserByRoleId(@PathVariable Integer rId){
        logger.info ("getUserByRoleId invoked with rule_id {}",rId);
        User userByRoleId = this.userService.getUserByRoleId (rId);
        logger.info ("end of getUserByRoleId with user object {}",userByRoleId);
        return new ResponseEntity<User> (userByRoleId,HttpStatus.OK);
    }
}
