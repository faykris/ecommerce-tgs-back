package com.faykris.ecommerce.Product;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {

  @Autowired
  private ProductService productService;

  @GetMapping(value = "all")
  public List<Product> getAllProducts() {
    return productService.getAllProducts();
  }

  @PostMapping()
  public List<Product> saveProducts(@RequestBody SetProductsRequest request) {
    return productService.saveProducts(request);
  }

  @PutMapping("/{productCode}")
  public ResponseEntity<Product> updateProduct(
      @PathVariable String productCode,
      @RequestBody UpdateProductRequest request) {
    Product product = productService.updateProduct(productCode, request);
    return ResponseEntity.ok(product);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteProduct(@PathVariable Integer id) {
    productService.deleteProduct(id);
    return ResponseEntity.noContent().build();
  }
}
