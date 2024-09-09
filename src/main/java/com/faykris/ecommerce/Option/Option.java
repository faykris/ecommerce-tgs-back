package com.faykris.ecommerce.Option;

import com.faykris.ecommerce.User.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="options")
public class Option {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Integer id;

  @ManyToOne
  @JoinColumn(name = "userId", referencedColumnName = "id")
  private User user;

  @Column(nullable = false)
  String name;

  String description;

  String stringValue;

  Integer integerValue;

  Double doubleValue;

  LocalDateTime timeValue;

  LocalDateTime createdAt;

  LocalDateTime updatedAt;
}
