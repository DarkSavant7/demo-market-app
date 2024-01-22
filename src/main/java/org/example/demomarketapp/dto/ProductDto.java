
package org.example.demomarketapp.dto;

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
public class ProductDto {
  Long id;
  String title;
  String description;
  BigDecimal price;
}
