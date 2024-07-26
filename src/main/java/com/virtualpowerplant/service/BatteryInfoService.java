package com.virtualpowerplant.service;

import com.virtualpowerplant.dto.BatteryStatistics;
import com.virtualpowerplant.dto.modelDto.BatteryResponse;
import com.virtualpowerplant.model.Battery;

import java.util.List;

/**
 * Service interface for managing battery information.
 *
 * @author santosh
 * @since 26 July 2024
 */
public interface BatteryInfoService {
  List<Battery> addBatteries(List<Battery> batteries);

  List<BatteryResponse> getBatteriesByPostcodeRange(String startPostcode, String endPostcode);

  BatteryStatistics calculateBatteryStatistics(List<Battery> sameNameBatteries, int totalBatteries);
}
