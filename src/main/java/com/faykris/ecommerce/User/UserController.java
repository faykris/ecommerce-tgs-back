package com.faykris.ecommerce.User;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping("/all")
  public List<User> getAllUsers() {
    return userService.getAllUsers();
  }

  @GetMapping
  public User getUser(@RequestParam String email) {
    return userService.getUserByEmail(email);
  }

  @PutMapping("/{email}")
  public ResponseEntity<User> updateUser(
      @PathVariable String email,
      @RequestBody UpdateUserRequest request) {
    User user = userService.updateUser(email, request);
    return ResponseEntity.ok(user);
  }
}
