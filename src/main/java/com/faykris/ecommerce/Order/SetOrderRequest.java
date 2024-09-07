package com.faykris.ecommerce.Order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SetOrderRequest {
    Integer userId;
    List<Integer> productIds;
    String description;
}
