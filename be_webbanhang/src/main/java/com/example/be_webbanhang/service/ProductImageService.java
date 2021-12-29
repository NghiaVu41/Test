package com.example.be_webbanhang.service;

import com.example.be_webbanhang.model.CategoryProduct;
import com.example.be_webbanhang.model.ProductImage;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.be_webbanhang.repository.ProductImageRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ProductImageService {

    private final ProductImageRepository productImageRepository;

    @Autowired
    public ProductImageService(ProductImageRepository productImageRepository) {
        this.productImageRepository = productImageRepository;
    }

    public List<ProductImage> findAll(){
        return productImageRepository.findAll();
    }

    public void addProductImage(ProductImage productImage){
        Optional<ProductImage> categoryProductOptional =
                productImageRepository.findProductImageById(productImage.getIdProductImage());
        if (categoryProductOptional.isPresent()) {
            throw new IllegalStateException("Id taken");
        }
        productImageRepository.save(productImage);
    }

    public void removeProductImage(int idProductImage){
        boolean exists = productImageRepository.existsById(idProductImage);
        if (!exists) {
            throw new IllegalStateException("category product with id " + idProductImage + " does not exists");
        }
        productImageRepository.deleteById(idProductImage);
    }

    @Transactional
    public ProductImage updateProductImage(ProductImage productImage, int idProductImage) {
        ProductImage productImage1 = this.productImageRepository.findOneById(idProductImage);
        BeanUtils.copyProperties(productImage, productImage1);
        return productImageRepository.saveAndFlush(productImage1);
    }

}
