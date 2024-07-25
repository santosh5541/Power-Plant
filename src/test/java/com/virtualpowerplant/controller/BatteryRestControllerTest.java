package com.virtualpowerplant.controller;

import com.virtualpowerplant.model.Battery;
import com.virtualpowerplant.service.BatteryInfoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;

public class BatteryRestControllerTest {

  @Mock
  private BatteryInfoService batteryInfoService;

  @InjectMocks
  private BatteryRestController batteryRestController;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  public void testAddBatteries_ServiceThrowsCustomException() {
    List<Battery> batteries = Collections.singletonList(new Battery());
    doThrow(new ResponseStatusException(HttpStatus.BAD_REQUEST, "BAD REQUEST")).when(batteryInfoService).addBatteries(batteries);
    ResponseStatusException exception = assertThrows(ResponseStatusException.class, () -> {
      batteryRestController.addBatteries(batteries);
    });
    assertEquals(HttpStatus.BAD_REQUEST, exception.getStatusCode());
  }

  @Test
  public void testAddBatteries_ServiceThrowsCustomExceptionWithDifferentMessage() {
    List<Battery> batteries = Collections.singletonList(new Battery());
    doThrow(new ResponseStatusException(HttpStatus.BAD_REQUEST, "BAD REQUEST")).when(batteryInfoService).addBatteries(batteries);

    ResponseStatusException exception = assertThrows(ResponseStatusException.class, () -> {
      batteryRestController.addBatteries(batteries);
    });
    assertEquals(HttpStatus.BAD_REQUEST, exception.getStatusCode());
  }

  @Test
  public void testAddBatteries_ServiceThrowsCustomExceptionWithDifferentStatus() {
    List<Battery> batteries = Collections.singletonList(new Battery());
    doThrow(new ResponseStatusException(HttpStatus.NOT_FOUND, "NOT FOUND")).when(batteryInfoService).addBatteries(batteries);

    ResponseStatusException exception = assertThrows(ResponseStatusException.class, () -> {
      batteryRestController.addBatteries(batteries);
    });

    assertEquals(HttpStatus.NOT_FOUND, exception.getStatusCode());
  }

  @Test
  public void testAddBatteries_ServiceThrowsCustomExceptionWithNullMessage() {
    List<Battery> batteries = Collections.singletonList(new Battery());
    doThrow(new ResponseStatusException(HttpStatus.BAD_REQUEST, null)).when(batteryInfoService).addBatteries(batteries);

    ResponseStatusException exception = assertThrows(ResponseStatusException.class, () -> {
      batteryRestController.addBatteries(batteries);
    });

    assertEquals(HttpStatus.BAD_REQUEST, exception.getStatusCode());
    assertEquals(null, exception.getReason());
  }

  @Test
  public void testAddBatteries_ServiceThrowsCustomExceptionWithEmptyMessage() {
    List<Battery> batteries = Collections.singletonList(new Battery());
    doThrow(new ResponseStatusException(HttpStatus.BAD_REQUEST, "BAD REQUEST")).when(batteryInfoService).addBatteries(batteries);
    ResponseStatusException exception = assertThrows(ResponseStatusException.class, () -> {
      batteryRestController.addBatteries(batteries);
    });
    assertEquals(HttpStatus.BAD_REQUEST, exception.getStatusCode());
    assertEquals("", exception.getReason());
  }
}