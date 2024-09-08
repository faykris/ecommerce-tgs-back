package com.faykris.ecommerce.Order;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order")
@RequiredArgsConstructor
public class OrderController {

  @Autowired
  private OrderService orderService;

  @GetMapping(value = "all")
  public List<SetProductsOrderResponse> getAllOrders() {
    return orderService.getAllOrders();
  }

  @PostMapping()
  public Order createOrder(@RequestBody SetOrderRequest request) {
    return orderService.saveOrder(request);
  }
}
