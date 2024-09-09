package com.faykris.ecommerce.Option;

import com.faykris.ecommerce.User.User;
import com.faykris.ecommerce.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OptionService {

  @Autowired
  private OptionRepository optionRepository;

  @Autowired
  private UserRepository userRepository;

  public List<Option> getAllOptions() {
    return optionRepository.findAll();
  }

  public Option saveOption(SetOptionRequest request) {
    User user = userRepository.findById(request.userId).orElseThrow(
        () -> new RuntimeException("User not found by id: " + request.userId));
    Option option = new Option();
    option.setUser(user);
    option.setName(request.name);
    option.setDescription(request.getDescription());
    option.setStringValue(request.getStringValue());
    option.setIntegerValue(request.getIntegerValue());
    option.setDoubleValue(request.getDoubleValue());
    option.setTimeValue(request.getTimeValue());
    option.setCreatedAt(LocalDateTime.now());

    return optionRepository.save(option);
  }
  public Option updateOption(Integer id, SetOptionRequest request) {
    Option option = optionRepository.findById(id).orElseThrow(
        () -> new RuntimeException("Option no found by id " + id));
    User user = userRepository.findById(request.userId).orElseThrow(
        () -> new RuntimeException("User not found by id: " + request.userId));
    if (request.getName() != null && !request.getName().trim().isEmpty()) {
      option.setName(request.getName());
    }
    if (request.getDescription() != null && !request.getDescription().trim().isEmpty()) {
      option.setDescription(request.getDescription());
    }
    if (request.getStringValue() != null && !request.getStringValue().trim().isEmpty()) {
      option.setStringValue(request.getStringValue());
    }
    if (request.getIntegerValue() != null) {
      option.setIntegerValue(request.getIntegerValue());
    }
    if (request.getDoubleValue() != null) {
      option.setDoubleValue(request.getDoubleValue());
    }
    if (request.getTimeValue() != null) {
      option.setTimeValue(request.getTimeValue());
    }
    option.setUser(user);
    option.setUpdatedAt(LocalDateTime.now());

    return optionRepository.save(option);
  }

}
