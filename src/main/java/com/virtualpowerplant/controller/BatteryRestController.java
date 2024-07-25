package com.virtualpowerplant.controller;

import com.virtualpowerplant.dto.modelDto.BatteryResponse;
import com.virtualpowerplant.model.Battery;
import com.virtualpowerplant.service.BatteryInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/batteries")
@RequiredArgsConstructor
public class BatteryRestController {
  private final BatteryInfoService batteryInfoService;

  @PostMapping
  public ResponseEntity<List<Battery>> addBatteries(@RequestBody List<Battery> batteries) {
    List<Battery> savedBatteries = batteryInfoService.addBatteries(batteries);
    return ResponseEntity.ok(savedBatteries);
  }

  @GetMapping
  public ResponseEntity<List<BatteryResponse>> getBatteriesByPostcodeRange(@RequestParam String startPostcode, @RequestParam String endPostcode) {
    List<BatteryResponse> batteries = batteryInfoService.getBatteriesByPostcodeRange(startPostcode, endPostcode);
    return ResponseEntity.ok(batteries);
  }
}
