package org.example.demomarketapp.repository;

import org.example.demomarketapp.model.ProductService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductServiceRepository extends JpaRepository<ProductService, Long> {
}
