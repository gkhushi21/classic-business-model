package com.businessmodel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.businessmodel.entity.ProductLine;

public interface ProductLineRepo extends JpaRepository<ProductLine, String> {

}
