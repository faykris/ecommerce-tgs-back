package com.faykris.ecommerce.Product;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="products")
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Integer id;

  String productCode;

  String category;

  @Column(nullable = false)
  String name;

  @Column(nullable = false)
  Double price;

  @Column(nullable = false)
  String description;

  String imageUrl;

  Integer status; // 1: available, 2: sold, 3: damaged

  LocalDateTime createdAt;

  LocalDateTime updatedAt;
}
