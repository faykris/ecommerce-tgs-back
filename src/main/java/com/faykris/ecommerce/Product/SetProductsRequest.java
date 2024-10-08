package com.faykris.ecommerce.Product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SetProductsRequest {
  Integer inventoryId;
  String name;
  String description;
  Double price;
  String imageUrl;
  String category;
  Integer quantity;
}
