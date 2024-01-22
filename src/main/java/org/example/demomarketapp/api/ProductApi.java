package org.example.demomarketapp.api;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import org.example.demomarketapp.dto.ProductDto;
import org.example.demomarketapp.dto.ProductShortDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface ProductApi {

  @PostMapping("/products")
  ResponseEntity<ProductDto> create(@RequestBody ProductDto dto);

  @GetMapping("/products/{id}")
  ResponseEntity<ProductDto> findById(@PathVariable(name = "id") Long id);

  @GetMapping("/products")
  ResponseEntity<List<ProductDto>> findAll();

  @DeleteMapping("/products/{id}")
  ResponseEntity<Void> deleteById(@PathVariable(name = "id") Long id);

  @GetMapping("/products/by-title")//url?param1=xxx&param2=yyyy
  ResponseEntity<List<ProductDto>> findByTitle(@RequestParam(name = "title") String title);

  @GetMapping("/products/by-price")
  ResponseEntity<List<ProductDto>> findByPriceGreaterThan(BigDecimal price);

  @GetMapping("/products/shorts")
  Set<ProductShortDto> findAllShorts();
}
