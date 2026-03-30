package com.businessmodel.mapper;

import com.businessmodel.dto.ProductDto;
import com.businessmodel.entity.Product;

public class ProductMapper {

    public static Product toProductEntity(ProductDto dto) {
        if (dto == null) return null;

        Product product = new Product();

        product.setProductCode(dto.getProductCode());
        product.setProductName(dto.getProductName());
        product.setProductLine(dto.getProductLine());
        product.setProductScale(dto.getProductScale());
        product.setProductVendor(dto.getProductVendor());
        product.setQuantityInStock(dto.getQuantityInStock());
        product.setBuyPrice(dto.getBuyPrice());
        product.setMsrp(dto.getMsrp());

        return product;
    }

    public static ProductDto toProductDto(Product product) {
        if (product == null) return null;

        return ProductDto.builder()
                .productCode(product.getProductCode())
                .productName(product.getProductName())
                .productLine(product.getProductLine())
                .productScale(product.getProductScale())
                .productVendor(product.getProductVendor())
                .quantityInStock(product.getQuantityInStock())
                .buyPrice(product.getBuyPrice())
                .msrp(product.getMsrp())
                .build();
    }

    public static void updateProductFromDto(ProductDto dto, Product product) {
        if (dto == null || product == null) return;

        product.setProductName(dto.getProductName());
        product.setProductLine(dto.getProductLine());
        product.setProductScale(dto.getProductScale());
        product.setProductVendor(dto.getProductVendor());
        product.setQuantityInStock(dto.getQuantityInStock());
        product.setBuyPrice(dto.getBuyPrice());
        product.setMsrp(dto.getMsrp());
    }
}