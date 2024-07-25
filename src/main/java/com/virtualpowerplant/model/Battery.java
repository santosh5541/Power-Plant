package com.virtualpowerplant.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("batteryInfo")
@Setter
@Getter
@NoArgsConstructor
public class Battery {
  private String batteryName;
  private String postcode;
  private int wattCapacity;
  private int size;
  private int total;
}
