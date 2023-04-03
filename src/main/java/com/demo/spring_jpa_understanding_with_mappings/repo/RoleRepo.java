package com.demo.spring_jpa_understanding_with_mappings.repo;

import com.demo.spring_jpa_understanding_with_mappings.entity.Role;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
@Profile ({"dev"})
public interface RoleRepo extends JpaRepository<Role,Integer> {

    @Query(value = "select r from Role r where r.roleName=?1")
    public Role getByRoleName(@Param ("roleName") String roleName);

}
