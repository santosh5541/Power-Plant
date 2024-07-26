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

/**
 * REST controller for managing battery information.
 * Provides endpoints for adding batteries and retrieving batteries by postcode range.
 *
 * @author santosh lutiel
 * @since 26 July 2024
 */
@RestController
@RequestMapping("/api/batteries")
@RequiredArgsConstructor
public class BatteryRestController {
  private final BatteryInfoService batteryInfoService;

  /**
   * Adds a list of batteries to the system.
   *
   * @param batteries the list of Battery objects to be added.
   * @return a ResponseEntity containing the list of saved Battery objects.
   * @author santosh lutiel
   * @since 26 July 2024
   */
  @PostMapping
  public ResponseEntity<List<Battery>> addBatteries(@RequestBody List<Battery> batteries) {
    List<Battery> savedBatteries = batteryInfoService.addBatteries(batteries);
    return ResponseEntity.ok(savedBatteries);
  }

  /**
   * Retrieves a list of batteries within a specified postcode range.
   *
   * @param startPostcode the starting postcode of the range (inclusive).
   * @param endPostcode   the ending postcode of the range (inclusive).
   * @return a ResponseEntity containing a list of BatteryResponse objects that fall within the specified postcode range.
   * @author santosh lutiel
   * @since 26 July 2024
   */
  @GetMapping
  public ResponseEntity<List<BatteryResponse>> getBatteriesByPostcodeRange(@RequestParam String startPostcode, @RequestParam String endPostcode) {
    List<BatteryResponse> batteries = batteryInfoService.getBatteriesByPostcodeRange(startPostcode, endPostcode);
    return ResponseEntity.ok(batteries);
  }
}
