package com.example.be_webbanhang.repository;


import com.example.be_webbanhang.model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface StaffRepository extends JpaRepository<Staff,Integer> {

    @Query("select s from Staff s where s.idStaff = ?1")
    Optional<Staff> findStaffById(Integer id);

    @Query("select s from Staff s where s.idStaff = ?1")
    Staff findOneById(Integer id);

    @Query("select s from Staff s where s.username = ?1 and s.password = ?1")
    Staff findStaffByUsPw(String username,String password);
}
