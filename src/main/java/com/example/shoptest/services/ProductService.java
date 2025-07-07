package com.example.shoptest.services;

import com.example.shoptest.models.Product;
import com.example.shoptest.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j         //логирование
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> listProducts(String title) {
        List<Product> products = productRepository.findAll();
        if (title != null){
            return productRepository.findByTitle(title);
        }
        return productRepository.findAll();
    }

    public void saveProduct(Product product) {
        log.info("saving new {}", product);
        productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }
}