package com.example.shoptest.repositories;

import com.example.shoptest.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//наследование от этого интерфейса (jpa) дает нам возможности сервиса на создание удаление добавление с коробки
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByTitle(String title);
}
