package org.example.demomarketapp.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "products")
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column
    String title;

    @Column
    String description;

    @Column
    BigDecimal price;

    @CreationTimestamp
    @Column(updatable = false)
    LocalDateTime created;

    @UpdateTimestamp
    LocalDateTime updated;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<ProductService> productServices;

//  @CreatedBy
//  Long createdBy;
//
//  @LastModifiedBy
//  Long updatedBy;
}
