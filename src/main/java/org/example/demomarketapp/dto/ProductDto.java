
package org.example.demomarketapp.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Builder
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Schema(description = "test test")
public class ProductDto {
  Long id;
  String title;
  @Schema(description = "Description of the product")
  String description;
  BigDecimal price;
}
