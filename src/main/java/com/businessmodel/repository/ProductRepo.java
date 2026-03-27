package com.businessmodel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.businessmodel.entity.Product;

public interface ProductRepo extends JpaRepository<Product, String> {

}
