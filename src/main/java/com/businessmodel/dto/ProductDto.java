package com.businessmodel.dto;

import com.businessmodel.entity.ProductLine;
import lombok.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

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
    private ProductLine productLine;

    @NotBlank(message = "Product scale is required")
    private String productScale;

    @NotBlank(message = "Product vendor is required")
    private String productVendor;

    @NotNull(message = "Quantity is required")
    private Short quantityInStock;

    @NotNull(message = "Buy price is required")
    private BigDecimal buyPrice;

    @NotNull(message = "MSRP is required")
    private BigDecimal msrp;
}