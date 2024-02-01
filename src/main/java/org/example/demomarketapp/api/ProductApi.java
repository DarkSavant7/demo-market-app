package org.example.demomarketapp.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.example.demomarketapp.dto.ProductDto;
import org.example.demomarketapp.dto.ProductShortDto;
import org.example.demomarketapp.dto.ProductWithServiceDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;


@Tag(name = "Products")
public interface ProductApi {

    @PostMapping("/products")
    ResponseEntity<ProductDto> create(@Valid @RequestBody ProductDto dto);

    @GetMapping("/products/{id}")
    ResponseEntity<ProductDto> findById(@PathVariable(name = "id") Long id);

    @GetMapping("/products")
    @Operation(summary = "Get all products")
    ResponseEntity<List<ProductDto>> findAll();

    @DeleteMapping("/products/{id}")
    ResponseEntity<Void> deleteById(@PathVariable(name = "id") Long id);

    @GetMapping("/products/by-title")
//url?param1=xxx&param2=yyyy
    ResponseEntity<List<ProductDto>> findByTitle(@RequestParam(name = "title") String title);

    @GetMapping("/products/by-price")
    ResponseEntity<List<ProductDto>> findByPriceGreaterThan(BigDecimal price);

    @GetMapping("/products/shorts")
    Set<ProductShortDto> findAllShorts();

    @GetMapping("/products/service/{id}")
    ProductWithServiceDto findProductServiceById(@PathVariable(name = "id") Long id);
}
