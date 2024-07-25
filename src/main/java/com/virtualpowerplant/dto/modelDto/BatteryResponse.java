package com.virtualpowerplant.dto.modelDto;

import com.virtualpowerplant.dto.BatteryStatistics;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BatteryResponse {
  private String batteryName;
  private String postcode;
  private int total;
  private BatteryStatistics batteryStatistics;
}

