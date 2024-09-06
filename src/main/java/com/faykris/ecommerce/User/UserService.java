package com.faykris.ecommerce.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;
  @Autowired
  private PasswordEncoder passwordEncoder;

  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  public User getUserByEmail(String email) {
    return userRepository.findByUsername(email)
        .orElseThrow(() ->
            new UsernameNotFoundException("User not found by email: " + email));
  }

  public User updateUser(String email, UpdateUserRequest request) {
    User user = getUserByEmail(email);
    user.setFirstname(request.getFirstname());
    user.setLastname(request.getLastname());
    user.setPhone(request.getPhone());
    if (request.getPassword() != null && !request.getPassword().trim().isEmpty()) {
      user.setPassword(passwordEncoder.encode(request.getPassword()));
    }
    user.setUpdatedAt(LocalDateTime.now());
    return userRepository.save(user);
  }
}
