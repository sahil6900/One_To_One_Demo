package com.demo.spring_jpa_understanding_with_mappings.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(
        name = "uEmail",
        columnNames = "email"
))
public class User {
    @Id
    @SequenceGenerator (
            name = "user_id",
    sequenceName = "user_id"
            ,initialValue = 100
    ,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String uName;
    private String uSurname;
    private String email;

    @OneToOne(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE,
                    CascadeType.REFRESH
            },
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            name = "roleId",
            referencedColumnName = "roleId"
    )
    @JsonManagedReference
    private Role role;

//    public User (Integer id , String uName , String uSurname , String email , Role role) {
//        this.id = id;
//        this.uName = uName;
//        this.uSurname = uSurname;
//        this.email = email;
//        this.role = role;
//    }

//    public User () {
//    }

    public Integer getId () {
        return id;
    }

    public void setId (Integer id) {
        this.id = id;
    }

    public String getuName () {
        return uName;
    }

    public void setuName (String uName) {
        this.uName = uName;
    }

    public String getuSurname () {
        return uSurname;
    }

    public void setuSurname (String uSurname) {
        this.uSurname = uSurname;
    }

    public String getEmail () {
        return email;
    }

    public void setEmail (String email) {
        this.email = email;
    }

    public Role getRole () {
        return role;
    }

    public void setRole (Role role) {
        this.role = role;
    }

//    @Override
//    public String toString () {
//        return "User{" +
//                "id=" + id +
//                ", uName='" + uName + '\'' +
//                ", uSurname='" + uSurname + '\'' +
//                ", email='" + email + '\'' +
//                ", role=" + role +
//                '}';
//    }
}
