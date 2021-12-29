package com.example.be_webbanhang.repository;

import com.example.be_webbanhang.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    @Query("select s from User s where s.idUser = ?1")
    Optional<User> findUserById(Integer id);

    @Query("select s from User s where s.idUser = ?1")
    User findOneById(Integer id);
}
