package com.faykris.ecommerce.Inventory;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/inventory")
@RequiredArgsConstructor
public class InventoryController {

  @Autowired
  private InventoryService inventoryService;

  @GetMapping(value = "all")
  public List<Inventory> getAllInventory() {
    return inventoryService.getAllInventory();
  }

  @PostMapping()
  public Inventory addInventory(@RequestBody SetInventoryRequest request) {
    return inventoryService.saveInventory(request);
  }

  @PutMapping("/{id}")
  public Inventory updateInventory(
      @PathVariable Integer id,
      @RequestBody SetInventoryRequest request) {
    return inventoryService.updateInventory(id, request);
  }

}
