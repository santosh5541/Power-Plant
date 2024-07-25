package com.virtualpowerplant.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("batteryStatistics")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BatteryStatistics {
  private int totalWattCapacity;
  private double averageWattCapacity;
}
