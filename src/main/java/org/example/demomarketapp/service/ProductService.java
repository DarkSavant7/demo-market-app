package org.example.demomarketapp.service;

import org.example.demomarketapp.dto.ProductDto;
import org.example.demomarketapp.dto.ProductShortDto;
import org.example.demomarketapp.dto.ProductWithServiceDto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

public interface ProductService {

    ProductDto create(ProductDto dto);

    ProductDto findById(Long id);

    List<ProductDto> findAll();

    void deleteById(Long id);

    List<ProductDto> findByTitleLike(String title);

    ProductDto findByTitleExact(String title);

    List<ProductDto> findByPriceGreaterThan(BigDecimal price);

    Set<ProductShortDto> findAllShorts();

    ProductWithServiceDto findProductServiceById(Long id);

    boolean existsByDescriptionAndTitleAndPrice(String description, String title, BigDecimal price);
}
