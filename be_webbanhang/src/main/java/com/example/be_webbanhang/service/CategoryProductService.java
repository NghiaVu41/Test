package com.example.be_webbanhang.service;

import com.example.be_webbanhang.model.CategoryProduct;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.be_webbanhang.repository.CategoryProductRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryProductService {

    private final CategoryProductRepository categoryProductRepository;

    @Autowired
    public CategoryProductService(CategoryProductRepository categoryProductRepository) {
        this.categoryProductRepository = categoryProductRepository;
    }

    public List<CategoryProduct> findAll(){
        return categoryProductRepository.findAll();
    }

    public void addCategoryProduct(CategoryProduct categoryProduct){
        Optional<CategoryProduct> categoryProductOptional =
                categoryProductRepository.findCategoryProductById(categoryProduct.getIdCategory());
        if (categoryProductOptional.isPresent()) {
            throw new IllegalStateException("Id taken");
        }
        categoryProductRepository.save(categoryProduct);
    }

    public void removeCategoryProduct(int idCategoryProduct){
        boolean exists = categoryProductRepository.existsById(idCategoryProduct);
        if (!exists) {
            throw new IllegalStateException("category product with id " + idCategoryProduct + " does not exists");
        }
        categoryProductRepository.deleteById(idCategoryProduct);
    }

    @Transactional
    public CategoryProduct updateCategoryProduct(CategoryProduct categoryProduct, int idCategoryProduct) {
        CategoryProduct categoryProduct1 = this.categoryProductRepository.findOneById(idCategoryProduct);
        BeanUtils.copyProperties(categoryProduct, categoryProduct1);
        return categoryProductRepository.saveAndFlush(categoryProduct1);
    }

}
