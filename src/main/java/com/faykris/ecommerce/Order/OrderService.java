package com.faykris.ecommerce.Order;

import com.faykris.ecommerce.Product.Product;
import com.faykris.ecommerce.Product.ProductRepository;
import com.faykris.ecommerce.User.User;
import com.faykris.ecommerce.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {

  @Autowired
  private OrderRepository orderRepository;

  @Autowired
  private ProductRepository productRepository;

  @Autowired
  private UserRepository userRepository;

  public List<Order> getAllOrders() {
    return orderRepository.findAll();
  }

  public Order saveOrder(SetOrderRequest request) {
    System.out.println("productIds from request:" + request.productIds + "----------");
    System.out.println("description from request:" + request.description + "----------");
    System.out.println("userId from request:" + request.userId + "----------");
    User user = userRepository.findById(request.userId).orElseThrow(
        () -> new RuntimeException("User not found by id: " + request.userId));
    List<Product> products = productRepository.findAllById(request.productIds);
    if (products.isEmpty()) {
      throw new RuntimeException("No one product was found in list");
    }
    for (Product product : products) {
      if (product.getStatus() != 1) {
        throw new RuntimeException("Product is not available in stock, Id: " + product.getId() + ", status: ");
      }
    }
    Order order = new Order();
    order.setUser(user);
    order.setDescription(request.description);
    order.setCreatedAt(LocalDateTime.now());

    Order savedOrder = orderRepository.save(order);
    for (Product product : products) {
      product.setOrder(savedOrder);
      product.setStatus(2);
      product.setUpdatedAt(LocalDateTime.now());
    }
    productRepository.saveAll(products);

    return savedOrder;
  }


}
