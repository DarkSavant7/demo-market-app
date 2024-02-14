package org.example.demomarketapp.web;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Collections;
import org.example.demomarketapp.dto.ProductDto;
import org.example.demomarketapp.model.Product;
import org.example.demomarketapp.repository.ProductRepository;
import org.example.demomarketapp.service.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class MainProductControllerTest {

  @Autowired
  ProductService productService;
  @MockBean
  ProductRepository productRepository;
  @Autowired
  ProductController productController;

  @Test
  void createProductTest() throws Exception {
    ProductDto dto = new ProductDto(null, "Test", "Description", BigDecimal.ONE);
    when(productRepository.existsByDescriptionAndTitleAndPrice(any(), any(), any())).thenReturn(
        Boolean.FALSE);
    Product product = new Product(1L, "Title", "Description", BigDecimal.ONE, null, null,
        Collections.emptyList());
    when(productRepository.save(any())).thenReturn(product);
    ProductDto result = productController.create(dto).getBody();
    Assertions.assertEquals("Title", result.getTitle());
  }
}