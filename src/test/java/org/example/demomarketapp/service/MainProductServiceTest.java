package org.example.demomarketapp.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;
import org.example.demomarketapp.dto.ProductDto;
import org.example.demomarketapp.error.ProductNotFoundException;
import org.example.demomarketapp.model.Product;
import org.example.demomarketapp.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class MainProductServiceTest {

  @Mock
  ProductRepository productRepository;
  ProductService productService;

  @BeforeEach
  void init() {
    productService = new MainProductService(productRepository);
  }

  @Test
  void findById_ShouldReturnAProduct() {
    Long id = 1L;
    Product product = new Product(id, "title", "description", BigDecimal.ONE, null, null, null);
    ProductDto dto = new ProductDto(product.getId(), product.getTitle(), product.getDescription(),
        product.getPrice());
    when(productRepository.findById(id)).thenReturn(Optional.of(product));
    var result = productService.findById(id);
    assertThat(result).isNotNull().isEqualTo(dto);
  }

  @Test
  void findById_ShouldThrowException() {
    Long id = 1L;
//    UUID anotherId = UUID.fromString("c7ae63f8-7ad3-4438-b9d3-7e4dc97bf644");
    when(productRepository.findById(id)).thenReturn(Optional.empty());
    assertThrows(ProductNotFoundException.class, () -> productService.findById(id));
  }
}