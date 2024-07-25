package com.virtualpowerplant.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BatteryTest {

  @Test
  public void testNoArgsConstructor() {
    Battery battery = new Battery();
    assertNotNull(battery);
  }

  @Test
  public void testSetAndGetBatteryName() {
    Battery battery = new Battery();
    battery.setBatteryName("PowerHouse");
    assertEquals("PowerHouse", battery.getBatteryName());
  }

  @Test
  public void testSetAndGetPostcode() {
    Battery battery = new Battery();
    battery.setPostcode("12345");
    assertEquals("12345", battery.getPostcode());
  }

  @Test
  public void testSetAndGetWattCapacity() {
    Battery battery = new Battery();
    battery.setWattCapacity(5000);
    assertEquals(5000, battery.getWattCapacity());
  }

  @Test
  public void testSetAndGetSize() {
    Battery battery = new Battery();
    battery.setSize(10);
    assertEquals(10, battery.getSize());
  }

  @Test
  public void testSetAndGetTotal() {
    Battery battery = new Battery();
    battery.setTotal(100);
    assertEquals(100, battery.getTotal());
  }
}