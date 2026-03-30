package com.businessmodel.dto;

import lombok.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SupportDto {

    private Integer customerNumber;
    private String customerName;
    private String phone;
    private String country;
    private List<ProductDto> orderedProducts;
}
