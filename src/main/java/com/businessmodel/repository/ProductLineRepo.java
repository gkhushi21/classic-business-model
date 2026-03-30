package com.businessmodel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.businessmodel.entity.ProductLine;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductLineRepo extends JpaRepository<ProductLine, String> {

}
