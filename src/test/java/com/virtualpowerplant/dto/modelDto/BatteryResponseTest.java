package com.virtualpowerplant.dto.modelDto;

import com.virtualpowerplant.dto.BatteryStatistics;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BatteryResponseTest {

  @Test
  public void testAllArgsConstructor() {
    BatteryStatistics batteryStatistics = new BatteryStatistics(1000, 500.0);
    BatteryResponse batteryResponse = new BatteryResponse("Battery1", "12345", 100, batteryStatistics);

    assertEquals("Battery1", batteryResponse.getBatteryName());
    assertEquals("12345", batteryResponse.getPostcode());
    assertEquals(100, batteryResponse.getTotal());
    assertEquals(batteryStatistics, batteryResponse.getBatteryStatistics());
  }

  @Test
  public void testGetters() {
    BatteryStatistics batteryStatistics = new BatteryStatistics(1000, 500.0);
    BatteryResponse batteryResponse = new BatteryResponse("Battery1", "12345", 100, batteryStatistics);

    assertEquals("Battery1", batteryResponse.getBatteryName());
    assertEquals("12345", batteryResponse.getPostcode());
    assertEquals(100, batteryResponse.getTotal());
    assertEquals(batteryStatistics, batteryResponse.getBatteryStatistics());
  }

  @Test
  public void testSetters() {
    BatteryStatistics batteryStatistics = new BatteryStatistics(1000, 500.0);
    BatteryResponse batteryResponse = new BatteryResponse("Battery1", "12345", 100, batteryStatistics);

    batteryResponse.setBatteryName("Battery2");
    batteryResponse.setPostcode("67890");
    batteryResponse.setTotal(200);
    BatteryStatistics newBatteryStatistics = new BatteryStatistics(2000, 1000.0);
    batteryResponse.setBatteryStatistics(newBatteryStatistics);

    assertEquals("Battery2", batteryResponse.getBatteryName());
    assertEquals("67890", batteryResponse.getPostcode());
    assertEquals(200, batteryResponse.getTotal());
    assertEquals(newBatteryStatistics, batteryResponse.getBatteryStatistics());
  }

  @Test
  public void testNoArgsConstructor() {
    BatteryResponse batteryResponse = new BatteryResponse(null, null, 0, null);
    assertNotNull(batteryResponse);
  }

  @Test
  public void testPartialArgsConstructor() {
    BatteryStatistics batteryStatistics = new BatteryStatistics(1000, 500.0);
    BatteryResponse batteryResponse = new BatteryResponse("Battery1", null, 0, batteryStatistics);

    assertEquals("Battery1", batteryResponse.getBatteryName());
    assertEquals(null, batteryResponse.getPostcode());
    assertEquals(0, batteryResponse.getTotal());
    assertEquals(batteryStatistics, batteryResponse.getBatteryStatistics());
  }
}