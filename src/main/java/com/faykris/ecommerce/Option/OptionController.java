package com.faykris.ecommerce.Option;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/option")
@RequiredArgsConstructor
public class OptionController {

  @Autowired
  private OptionService optionService;

  @GetMapping(value = "all")
  public List<Option> getAllOptions() {
    return optionService.getAllOptions();
  }

  @PostMapping
  public Option createOption(@RequestBody SetOptionRequest request) {
    return optionService.saveOption(request);
  }

  @PutMapping("/{id}")
  public Option updateOption(
      @PathVariable Integer id,
      @RequestBody SetOptionRequest request) {
    return optionService.updateOption(id, request);
  }
}
