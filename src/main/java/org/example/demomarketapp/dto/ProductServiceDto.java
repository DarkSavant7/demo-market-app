package org.example.demomarketapp.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductServiceDto {

    private String title;
    private String description;
    private BigDecimal price;

}
