package com.demo.spring_jpa_understanding_with_mappings.controller;

import com.demo.spring_jpa_understanding_with_mappings.entity.Role;
import com.demo.spring_jpa_understanding_with_mappings.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/role")
public class RoleController {

    private static final Logger logger = LoggerFactory.getLogger (RoleController.class);
    @Autowired
    private RoleService roleService;

    @PostMapping("/create")
    public ResponseEntity<Role> createRole(@RequestBody Role role){
        logger.info ("createRole invoked and getting object as {}",role);

        Role createdRole = this.roleService.createRole (role);

        logger.info("created role object as {}",createdRole);

        return new ResponseEntity<Role> (createdRole, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Role> updateRole(@PathVariable Integer id,@RequestBody Role role){
        Role updatedRole = this.roleService.updateRole (id , role);

        return new ResponseEntity<Role> (updatedRole,HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Role> getRoleById(@PathVariable Integer id){
        logger.info ("getById method invoked with id as {}",id);
        Role roleById = this.roleService.getRoleById (id);

        logger.info ("got object of {}",roleById);
        return new ResponseEntity<Role> (roleById,HttpStatus.OK);
    }

    @GetMapping("/all/roles")
    public ResponseEntity<List<Role>> getAllRoles(){
        List<Role> allRoles = this.roleService.getAllRoles ();

        return new ResponseEntity<List<Role>> (allRoles,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteRole(@PathVariable Integer id){
        String s = this.roleService.deleteRole (id);

        return new ResponseEntity<String> (s,HttpStatus.OK);
    }
}
