package com.virtualpowerplant.service;

import com.virtualpowerplant.dto.BatteryStatistics;
import com.virtualpowerplant.dto.modelDto.BatteryResponse;
import com.virtualpowerplant.model.Battery;

import java.util.List;

public interface BatteryInfoService {
  List<Battery> addBatteries(List<Battery> batteries);

  List<BatteryResponse> getBatteriesByPostcodeRange(String startPostcode, String endPostcode);

  BatteryStatistics calculateBatteryStatistics(List<Battery> sameNameBatteries, int totalBatteries);
}
