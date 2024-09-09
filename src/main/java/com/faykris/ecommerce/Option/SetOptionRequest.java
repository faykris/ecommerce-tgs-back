package com.faykris.ecommerce.Option;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SetOptionRequest {
  Integer userId;
  String name;
  String description;
  String stringValue;
  Integer integerValue;
  Double doubleValue;
  LocalDateTime timeValue;
}
