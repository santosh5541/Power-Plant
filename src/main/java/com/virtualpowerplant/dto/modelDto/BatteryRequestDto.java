package com.virtualpowerplant.dto.modelDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BatteryRequestDto {
  private String batteryName;
  private String postcode;
  private int wattCapacity;
  private int size;
}
