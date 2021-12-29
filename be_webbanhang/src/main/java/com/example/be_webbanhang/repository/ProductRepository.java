package com.example.be_webbanhang.repository;

import com.example.be_webbanhang.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

    @Query("select s from Product s where s.idProduct = ?1")
    Optional<Product> findProductById(Integer id);

    @Query("select s from Product s where s.idProduct = ?1")
    Product findOneById(Integer id);

    @Query("select s from Product s where s.category_product.idCategory = ?1")
    List<Product> findListroductByidCatetory(Integer idCategory);
}
