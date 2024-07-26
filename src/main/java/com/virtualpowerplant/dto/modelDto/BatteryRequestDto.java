package com.virtualpowerplant.dto.modelDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Data Transfer Object for battery requests.
 * This class is used to encapsulate the data for creating or updating a battery.
 *
 * @author santosh
 * @since 26 July 2024
 */
@Getter
@Setter
@NoArgsConstructor
public class BatteryRequestDto {
  private String batteryName;
  private String postcode;
  private int wattCapacity;
  private int size;
}
