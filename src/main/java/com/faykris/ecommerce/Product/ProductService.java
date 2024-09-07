package com.faykris.ecommerce.Product;

import com.faykris.ecommerce.Inventory.Inventory;
import com.faykris.ecommerce.Inventory.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

  @Autowired
  private ProductRepository productRepository;

  @Autowired
  private InventoryRepository inventoryRepository;

  public List<Product> getAllProducts() {
    return productRepository.findAll();
  }

  public List<Product> saveProducts(SetProductsRequest request) {
    Inventory inventory = inventoryRepository.findById(request.inventoryId).orElse(null);
    if (inventory == null) {
      throw new RuntimeException("Inventory not found with id " + request.inventoryId);
    }
    final String productCode = generateProductCode();
    List<Product> products = new ArrayList<>();

    for (int i = 0; i < request.quantity; i++) {
      Product product = new Product();
      product.setInventory(inventory);
      product.setName(request.getName());
      product.setDescription(request.getDescription());
      product.setPrice(request.getPrice());
      product.setProductCode(productCode);
      product.setImageUrl(request.getImageUrl());
      product.setCategory(request.getCategory());
      product.setStatus(1);
      product.setCreatedAt(LocalDateTime.now());
      products.add(product);
    }

    return productRepository.saveAll(products);
  }

  private String generateProductCode() {
    return UUID.randomUUID().toString();
  }

  public Product updateProduct(String productCode, UpdateProductRequest request) {
    List<Product> products = productRepository.findAllByProductCode(productCode);
    if (products.isEmpty()) {
      throw new RuntimeException("No products found with product code " + productCode);
    }

    for (Product product : products) {
      product.setName(request.getName());
      product.setPrice(request.getPrice());
      product.setDescription(request.getDescription());
      product.setImageUrl(request.getImageUrl());
      product.setUpdatedAt(LocalDateTime.now());
    }

    return productRepository.saveAll(products).get(0);
  }

  public void deleteProduct(Integer id) {
    if (!productRepository.existsById(id)) {
      throw new RuntimeException("Product not found with ID " + id);
    }
    productRepository.deleteById(id);
  }
}
