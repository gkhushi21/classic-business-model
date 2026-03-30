package com.businessmodel.dto;

import lombok.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDto {

    @NotBlank(message = "Product code is required")
    private String productCode;

    @NotBlank(message = "Product name is required")
    private String productName;

    @NotBlank(message = "Product line is required")
    private String productLine;

    @NotBlank(message = "Product scale is required")
    private String productScale;

    @NotBlank(message = "Product vendor is required")
    private String productVendor;

    @NotNull(message = "Quantity is required")
    private int quantityInStock;

    @NotNull(message = "Buy price is required")
    private double buyPrice;

    @NotNull(message = "MSRP is required")
    private double msrp;
}