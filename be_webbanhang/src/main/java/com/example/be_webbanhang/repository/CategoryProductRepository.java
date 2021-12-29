package com.example.be_webbanhang.repository;

import com.example.be_webbanhang.model.CategoryProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryProductRepository extends JpaRepository<CategoryProduct,Integer> {

    @Query("select s from CategoryProduct s where s.idCategory = ?1")
    Optional<CategoryProduct> findCategoryProductById(Integer id);

    @Query("select s from CategoryProduct s where s.idCategory = ?1")
    CategoryProduct findOneById(Integer id);

}
