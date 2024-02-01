package org.example.demomarketapp.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.example.demomarketapp.validation.interf.CheckDtoFields;

import java.math.BigDecimal;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Builder
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Schema(description = "test test")
@CheckDtoFields
public class ProductDto {

    Long id;
    String title;
    @Schema(description = "Description of the product")
    String description;
    BigDecimal price;
}
