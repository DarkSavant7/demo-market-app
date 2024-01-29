package org.example.demomarketapp.dto;


import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductWithServiceDto {

    private Long id;
    private String title;
    private String description;
    private BigDecimal price;
    private List<ProductServiceDto> productServiceDtos;
}
