package com.faykris.ecommerce.Inventory;

import com.faykris.ecommerce.User.User;
import com.faykris.ecommerce.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class InventoryService {

  @Autowired
  private InventoryRepository inventoryRepository;

  @Autowired
  private UserRepository userRepository;

  public List<Inventory> getAllInventory() {
    return inventoryRepository.findAll();
  }

  public Inventory saveInventory(SetInventoryRequest request) {
    User user = userRepository.findById(request.userId).orElseThrow(
        () -> new RuntimeException("User not found by id: " + request.userId));
    Inventory inventory = new Inventory();
    inventory.setUser(user);
    inventory.setName(request.getName());
    inventory.setCreatedAt(LocalDateTime.now());
    return inventoryRepository.save(inventory);
  }

  public Inventory updateInventory(Integer id, SetInventoryRequest request) {
    Inventory inventory = inventoryRepository.findById(id).orElse(null);
    if (inventory == null) {
      throw new RuntimeException("Inventory not found with id " + id);
    }
    inventory.setName(request.getName());
    inventory.setUpdatedAt(LocalDateTime.now());
    return inventoryRepository.save(inventory);
  }
}
