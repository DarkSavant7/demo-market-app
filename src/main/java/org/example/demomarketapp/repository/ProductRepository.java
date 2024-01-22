package org.example.demomarketapp.repository;


import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.example.demomarketapp.dto.ProductShortDto;
import org.example.demomarketapp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

  @Query(value = "select p.* from products p where p.title like concat('%', :title, '%') ", nativeQuery = true)
  List<Product> findAllByTitleLike(@Param("title") String title);

  List<Product> findAllByPriceIsGreaterThanEqual(@Param("price") BigDecimal price);

  Optional<Product> findByTitle(@Param("title") String title);

  Optional<Product> findOneByTitleAndDescriptionOrPriceIsLessThanEqual(@Param("title") String title,
      @Param("description") String description, @Param("price") BigDecimal price);

  @Query(value = "select new org.example.demomarketapp.dto.ProductShortDto(prod.id, prod.title) from Product prod", nativeQuery = false)
  Set<ProductShortDto> findAllShorts();
}
