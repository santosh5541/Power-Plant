package com.virtualpowerplant.dto.modelDto;

import com.virtualpowerplant.dto.BatteryStatistics;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Data Transfer Object for battery responses.
 * This class is used to encapsulate the data for returning battery information.
 *
 * @author santosh
 * @since 26 July 2024
 */
@Getter
@Setter
@AllArgsConstructor
public class BatteryResponse {
  private String batteryName;
  private String postcode;
  private int total;
  private BatteryStatistics batteryStatistics;
}

