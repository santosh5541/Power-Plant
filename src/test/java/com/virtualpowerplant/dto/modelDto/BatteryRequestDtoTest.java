package com.virtualpowerplant.dto.modelDto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BatteryRequestDtoTest {

  @Test
  public void testNoArgsConstructor() {
    BatteryRequestDto batteryRequestDto = new BatteryRequestDto();
    assertNotNull(batteryRequestDto);
  }

  @Test
  public void testSetAndGetBatteryName() {
    BatteryRequestDto batteryRequestDto = new BatteryRequestDto();
    batteryRequestDto.setBatteryName("Battery");
    assertEquals("Battery", batteryRequestDto.getBatteryName());
  }

  @Test
  public void testSetAndGetPostcode() {
    BatteryRequestDto batteryRequestDto = new BatteryRequestDto();
    batteryRequestDto.setPostcode("12345");
    assertEquals("12345", batteryRequestDto.getPostcode());
  }

  @Test
  public void testSetAndGetWattCapacity() {
    BatteryRequestDto batteryRequestDto = new BatteryRequestDto();
    batteryRequestDto.setWattCapacity(5000);
    assertEquals(5000, batteryRequestDto.getWattCapacity());
  }

  @Test
  public void testSetAndGetSize() {
    BatteryRequestDto batteryRequestDto = new BatteryRequestDto();
    batteryRequestDto.setSize(10);
    assertEquals(10, batteryRequestDto.getSize());
  }
}
