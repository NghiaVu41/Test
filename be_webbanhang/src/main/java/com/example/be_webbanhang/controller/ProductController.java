package com.example.be_webbanhang.controller;


import com.example.be_webbanhang.model.CategoryProduct;
import com.example.be_webbanhang.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.be_webbanhang.service.ProductService;
import com.example.be_webbanhang.repository.ProductRepository;

import java.util.List;

@RestController
@RequestMapping("/product")
@CrossOrigin("*")
public class ProductController {

    private final ProductService productService;
    private final ProductRepository productRepository;

    @Autowired
    public ProductController(ProductService productService, ProductRepository productRepository) {
        this.productService = productService;
        this.productRepository = productRepository;
    }

    @GetMapping("/findAll")
    public List<Product> findAll(){
        return productService.findAll();
    }

    @GetMapping("/findProductById/{id}")
    public Product findCategoryById(@PathVariable("id") int idProduct){
        return productRepository.findOneById(idProduct);
    }

    @GetMapping("/findListProductByIdCategory/{id}")
    public List<Product> findListroductByidCatetory(@PathVariable("id") int idCategory){
        return productRepository.findListroductByidCatetory(idCategory);
    }

    @PostMapping("/addProduct")
    public void addProduct(@RequestBody Product product){
        productService.addProduct(product);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public void deleteProduct(@PathVariable("id") int idProduct) {
        productService.removeProduct(idProduct);
    }

    @PutMapping("/updateProduct/{id}")
    public Product updateProduct(@RequestBody Product product,
                             @PathVariable("id") int idProduct) {
        return productService.updateProduct(product, idProduct);
    }
}
