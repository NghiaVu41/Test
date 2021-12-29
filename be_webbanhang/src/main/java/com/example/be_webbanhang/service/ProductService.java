package com.example.be_webbanhang.service;

import com.example.be_webbanhang.model.Product;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.be_webbanhang.repository.ProductRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public void addProduct(Product product){
        Optional<Product> productOptional =
                productRepository.findProductById(product.getIdProduct());
        if (productOptional.isPresent()) {
            throw new IllegalStateException("Id taken");
        }
        productRepository.save(product);
    }

    public void removeProduct(int idProduct){
        boolean exists = productRepository.existsById(idProduct);
        if (!exists) {
            throw new IllegalStateException("role with id " + idProduct + " does not exists");
        }
        productRepository.deleteById(idProduct);
    }

    @Transactional
    public Product updateProduct(Product product, int idProduct) {
        Product product1 = this.productRepository.findOneById(idProduct);
        BeanUtils.copyProperties(product, product1);
        return productRepository.saveAndFlush(product1);
    }
}
