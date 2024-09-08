package com.faykris.ecommerce.Order;

import com.faykris.ecommerce.Product.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SetProductsOrderResponse {
  private Order order;
  private List<Product> products;
}
