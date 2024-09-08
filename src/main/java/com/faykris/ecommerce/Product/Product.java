package com.faykris.ecommerce.Product;

import com.faykris.ecommerce.Inventory.Inventory;
import com.faykris.ecommerce.Order.Order;
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

  Integer status; // 1: available, 2: shipped, 3: damaged

  @ManyToOne
  @JoinColumn(name = "inventoryId", referencedColumnName = "id", nullable = false)
  private Inventory inventory;

  @ManyToOne
  @JoinColumn(name = "orderId", referencedColumnName = "id")
  private Order order;

  LocalDateTime createdAt;

  LocalDateTime updatedAt;
}
