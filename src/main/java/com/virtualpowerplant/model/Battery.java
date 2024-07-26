package com.virtualpowerplant.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Document representing battery information.
 * This class is used to encapsulate the data of a battery.
 *
 * @author santosh
 * @since 26 July 2024
 */
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
