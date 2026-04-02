package com.businessmodel.repository;

import com.businessmodel.entity.ProductLine;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.businessmodel.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, String> {
    public Page<Product> findProductByProductLine(ProductLine productLine, Pageable pageable);

}