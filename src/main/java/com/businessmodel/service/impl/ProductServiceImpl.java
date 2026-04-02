package com.businessmodel.service.impl;

import com.businessmodel.dto.ProductDto;
import com.businessmodel.entity.Product;
import com.businessmodel.entity.ProductLine;
import com.businessmodel.exception.BadRequestException;
import com.businessmodel.mapper.ProductMapper;
import com.businessmodel.repository.ProductRepo;
import com.businessmodel.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepo productRepo;
    @Override
    public Page<ProductDto> findProductsByProductLine(ProductLine productLine, int page, int size) {
        if (page < 0 || size <= 0) {
            throw new BadRequestException("Invalid pagination parameters");
        }
        if(productLine==null){
            throw new BadRequestException("ProductLine is required");
        }
        Pageable pageable = PageRequest.of(page, size);
        Page<Product> productPage=productRepo.findProductByProductLine(productLine,pageable);
        return productPage.map(product->ProductMapper.toProductDto(product));
    }
}