package com.virtualpowerplant.service;

import com.virtualpowerplant.dto.BatteryStatistics;
import com.virtualpowerplant.dto.modelDto.BatteryResponse;
import com.virtualpowerplant.model.Battery;
import com.virtualpowerplant.repository.BatteryRepository;
import com.virtualpowerplant.service.serviceImpl.BatteryInfoServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class BatteryInfoServiceImplTest {

  @Mock
  private BatteryRepository batteryRepository;

  @InjectMocks
  private BatteryInfoServiceImpl batteryInfoService;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  public void testAddBatteries() {
    Battery battery1 = new Battery();
    Battery battery2 = new Battery();
    List<Battery> batteries = Arrays.asList(battery1, battery2);

    when(batteryRepository.saveAll(batteries)).thenReturn(batteries);

    List<Battery> result = batteryInfoService.addBatteries(batteries);
    assertEquals(2, result.size());
  }

  @Test
  public void testGetBatteriesByPostcodeRange() {
    Battery battery1 = new Battery();
    battery1.setBatteryName("Power");
    battery1.setPostcode("12345");
    battery1.setWattCapacity(5000);
    battery1.setSize(10);
    battery1.setTotal(100);

    Battery battery2 = new Battery();
    battery2.setBatteryName("Horse");
    battery2.setPostcode("12346");
    battery2.setWattCapacity(6000);
    battery2.setSize(15);
    battery2.setTotal(150);

    List<Battery> batteries = Arrays.asList(battery1, battery2);

    when(batteryRepository.findByPostcodeBetween("12345", "12346")).thenReturn(batteries);

    List<BatteryResponse> result = batteryInfoService.getBatteriesByPostcodeRange("12345", "12346");
    assertEquals(2, result.size());
    assertEquals("12345", result.get(0).getPostcode());
    assertEquals("12346", result.get(1).getPostcode());
  }

  @Test
  public void testCalculateBatteryStatistics() {
    Battery battery1 = new Battery();
    battery1.setBatteryName("Power");
    battery1.setPostcode("12345");
    battery1.setWattCapacity(5000);
    battery1.setSize(10);
    battery1.setTotal(100);

    Battery battery2 = new Battery();
    battery2.setBatteryName("House");
    battery2.setPostcode("12345");
    battery2.setWattCapacity(6000);
    battery2.setSize(15);
    battery2.setTotal(150);

    List<Battery> batteries = Arrays.asList(battery1, battery2);

    BatteryStatistics result = batteryInfoService.calculateBatteryStatistics(batteries, 2);
    assertEquals(11000, result.getTotalWattCapacity());
    assertEquals(5500.0, result.getAverageWattCapacity());
  }

  @Test
  public void testGetBatteriesByPostcodeRange_EmptyResult() {
    when(batteryRepository.findByPostcodeBetween("12345", "12346")).thenReturn(Arrays.asList());

    List<BatteryResponse> result = batteryInfoService.getBatteriesByPostcodeRange("12345", "12346");
    assertEquals(0, result.size());
  }

  @Test
  public void testCalculateBatteryStatistics_NoBatteries() {
    List<Battery> batteries = Arrays.asList();

    BatteryStatistics result = batteryInfoService.calculateBatteryStatistics(batteries, 0);
    assertEquals(0, result.getTotalWattCapacity());
    assertEquals(0.0, result.getAverageWattCapacity());
  }
}