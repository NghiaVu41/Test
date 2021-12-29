package com.example.be_webbanhang.repository;

import com.example.be_webbanhang.model.CategoryProduct;
import com.example.be_webbanhang.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {

    @Query("select s from Role s where s.idRole = ?1")
    Optional<Role> findRoleById(Integer id);

    @Query("select s from Role s where s.idRole = ?1")
    Role findOneById(Integer id);
}
