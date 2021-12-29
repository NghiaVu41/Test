package com.example.be_webbanhang.repository;

import com.example.be_webbanhang.model.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductImageRepository extends JpaRepository<ProductImage,Integer> {

    @Query("select s from ProductImage s where s.idProductImage = ?1")
    Optional<ProductImage> findProductImageById(Integer id);

    @Query("select s from ProductImage s where s.idProductImage = ?1")
    ProductImage findOneById(Integer id);

    @Query("select s from ProductImage s where s.product.idProduct = ?1")
    List<ProductImage> findListProductImageByidProduct(Integer idProduct);
}
