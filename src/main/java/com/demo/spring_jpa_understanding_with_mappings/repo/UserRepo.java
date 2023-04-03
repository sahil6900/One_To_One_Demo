package com.demo.spring_jpa_understanding_with_mappings.repo;

import com.demo.spring_jpa_understanding_with_mappings.entity.User;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Profile ({"dev"})
public interface UserRepo extends JpaRepository<User,Integer> {

    //@Query("select u.id,u.uName from User u,Role r where r.roleId=?1")
//    @Query(value = "select User.uName,User.uSurname,Role.roleId from User INNER join Role on Role.roleId=User.id",nativeQuery = true)
//    public User getUserByRoleId(Integer id);

    @Query("select r from Role u join u.user r where u.roleId=:roleId")
    public User getUserByRoleId(@Param ("roleId") Integer id);
}
