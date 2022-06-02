package com.spring.iasfex2.service;

import com.spring.iasfex2.entity.Product;
import com.spring.iasfex2.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public Product save(Product obj) {
        return productRepository.save(obj);
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
