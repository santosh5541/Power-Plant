package com.virtualpowerplant.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Document representing battery statistics.
 * This class is used to encapsulate the statistical data of batteries.
 *
 * @author santosh
 * @since 26 July 2024
 */
@Document("batteryStatistics")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BatteryStatistics {
  private int totalWattCapacity;
  private double averageWattCapacity;
}
