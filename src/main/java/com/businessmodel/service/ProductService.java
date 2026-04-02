package com.businessmodel.service;

import com.businessmodel.dto.ProductDto;
import com.businessmodel.entity.ProductLine;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {
    public Page<ProductDto> findProductsByProductLine(ProductLine productLine, int page, int size);
}