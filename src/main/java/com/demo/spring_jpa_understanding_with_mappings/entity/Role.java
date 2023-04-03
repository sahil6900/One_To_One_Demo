package com.demo.spring_jpa_understanding_with_mappings.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Role {
    @Id
    @SequenceGenerator (
            name = "rId",
            sequenceName = "rId",
            initialValue = 200,
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer roleId;
    private String roleName;

    @OneToOne(
            cascade = CascadeType.ALL,
            mappedBy ="role",
            fetch = FetchType.LAZY
    )
    @JsonBackReference
    private User user;

    public Role (Integer roleId , String roleName , User user) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.user = user;
    }

    public Role () {
    }

    public Integer getRoleId () {
        return roleId;
    }

    public void setRoleId (Integer id) {
        this.roleId = id;
    }

    public String getRoleName () {
        return roleName;
    }

    public void setRoleName (String roleName) {
        this.roleName = roleName;
    }

    public User getUser () {
        return user;
    }

    public void setUser (User user) {
        this.user = user;
    }

//    @Override
//    public String toString () {
//        return "Role{" +
//                "roleId=" + roleId +
//                ", roleName='" + roleName + '\'' +
//                '}';
//    }
}
