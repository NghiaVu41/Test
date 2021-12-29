package com.example.be_webbanhang.controller;


import com.example.be_webbanhang.model.CategoryProduct;
import com.example.be_webbanhang.repository.CategoryProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.be_webbanhang.service.CategoryProductService;

import java.util.List;

@RestController
@RequestMapping("/categoryproduct")
@CrossOrigin("*")
public class CategoryProductController {

    private final CategoryProductService categoryProductService;
    private final CategoryProductRepository categoryProductRepository;

    @Autowired
    public CategoryProductController(CategoryProductService categoryProductService, CategoryProductRepository categoryProductRepository) {
        this.categoryProductService = categoryProductService;
        this.categoryProductRepository = categoryProductRepository;
    }

    @GetMapping("/findAll")
    public List<CategoryProduct> findAll(){
        return categoryProductService.findAll();
    }

    @GetMapping("/findCategoryById/{id}")
    public CategoryProduct findCategoryById(@PathVariable("id") int idCategoryProduct){
        return categoryProductRepository.findOneById(idCategoryProduct);
    }

    @PostMapping("/addCategoryProduct")
    public void addProduct(@RequestBody CategoryProduct categoryProduct){
        categoryProductService.addCategoryProduct(categoryProduct);
    }

    @DeleteMapping("/deleteCategoryProduct/{id}")
    public void deleteProduct(@PathVariable("id") int idCategoryProduct ) {
        categoryProductService.removeCategoryProduct(idCategoryProduct);
    }

    @PutMapping("/updateCategoryProduct/{id}")
    public CategoryProduct updateCategoryProduct(@RequestBody CategoryProduct categoryProduct,
                                 @PathVariable("id") int idCategoryProduct) {
        return categoryProductService.updateCategoryProduct(categoryProduct, idCategoryProduct);
    }
}
