package com.faykris.ecommerce.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserRequest {
  private String firstname;
  private String lastname;
  private String phone;
  private String password;
}
