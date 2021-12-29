package com.example.be_webbanhang.controller;


import com.example.be_webbanhang.model.Product;
import com.example.be_webbanhang.model.ProductImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.be_webbanhang.service.ProductImageService;
import com.example.be_webbanhang.repository.ProductImageRepository;

import java.util.List;

@RestController
@RequestMapping("/productimage")
@CrossOrigin("*")
public class ProductImageController {

    private final ProductImageService productImageService;
    private final ProductImageRepository productImageRepository;

    @Autowired
    public ProductImageController(ProductImageService productImageService, ProductImageRepository productImageRepository) {
        this.productImageService = productImageService;
        this.productImageRepository = productImageRepository;
    }

    @GetMapping("/findAll")
    public List<ProductImage> findAll(){
        return productImageService.findAll();
    }

    @GetMapping("/findProductImageById/{id}")
    public ProductImage findCategoryById(@PathVariable("id") int idProductImage){
        return productImageRepository.findOneById(idProductImage);
    }

    @GetMapping("/findListProductImageByidProduct/{id}")
    public List<ProductImage> findListProductImageByidProduct(@PathVariable("id") int idProduct){
        return productImageRepository.findListProductImageByidProduct(idProduct);
    }

    @PostMapping("/addProductImage")
    public void addProductImage(@RequestBody ProductImage productImage){
        productImageService.addProductImage(productImage);
    }

    @DeleteMapping("/deleteProductImage/{id}")
    public void deleteAdmin(@PathVariable("id") int idAdmin) {
        productImageService.removeProductImage(idAdmin);
    }

    @PutMapping("/updateProductImage/{id}")
    public ProductImage updateProductImage(@RequestBody ProductImage productImage,
                             @PathVariable("id") int idProductImage) {
        return productImageService.updateProductImage(productImage, idProductImage);
    }
}
