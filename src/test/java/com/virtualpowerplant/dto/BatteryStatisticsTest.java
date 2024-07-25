package com.virtualpowerplant.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BatteryStatisticsTest {

  @Test
  public void testNoArgsConstructor() {
    BatteryStatistics batteryStatistics = new BatteryStatistics();
    assertNotNull(batteryStatistics);
  }

  @Test
  public void testAllArgsConstructor() {
    BatteryStatistics batteryStatistics = new BatteryStatistics(1000, 500.0);
    assertEquals(1000, batteryStatistics.getTotalWattCapacity());
    assertEquals(500.0, batteryStatistics.getAverageWattCapacity());
  }

  @Test
  public void testGettersAndSetters() {
    BatteryStatistics batteryStatistics = new BatteryStatistics();
    batteryStatistics.setTotalWattCapacity(2000);
    batteryStatistics.setAverageWattCapacity(1000.0);
    assertEquals(2000, batteryStatistics.getTotalWattCapacity());
    assertEquals(1000.0, batteryStatistics.getAverageWattCapacity());
  }

  @Test
  public void testSetTotalWattCapacity() {
    BatteryStatistics batteryStatistics = new BatteryStatistics();
    batteryStatistics.setTotalWattCapacity(3000);
    assertEquals(3000, batteryStatistics.getTotalWattCapacity());
  }

  @Test
  public void testSetAverageWattCapacity() {
    BatteryStatistics batteryStatistics = new BatteryStatistics();
    batteryStatistics.setAverageWattCapacity(1500.0);
    assertEquals(1500.0, batteryStatistics.getAverageWattCapacity());
  }
}
