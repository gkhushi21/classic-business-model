package com.businessmodel.controller;

import com.businessmodel.dto.ProductDto;
import com.businessmodel.entity.ProductLine;
import com.businessmodel.service.ProductService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public Page<ProductDto> findProductsByProductLine(@RequestParam ProductLine productLine,
                                                      @RequestParam(defaultValue = "0") int page,
                                                      @RequestParam(defaultValue = "10") int size) {
        return productService.findProductsByProductLine(productLine,page,size);
    }

}