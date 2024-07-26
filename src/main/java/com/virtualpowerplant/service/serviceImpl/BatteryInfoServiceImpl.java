package com.virtualpowerplant.service.serviceImpl;

import com.virtualpowerplant.dto.BatteryStatistics;
import com.virtualpowerplant.dto.modelDto.BatteryResponse;
import com.virtualpowerplant.model.Battery;
import com.virtualpowerplant.repository.BatteryRepository;
import com.virtualpowerplant.service.BatteryInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Implementation of the BatteryInfoService interface.
 * This service provides methods to add batteries and retrieve battery information based on postcode range.
 *
 * @author santosh
 * @since 26 July 2024
 */
@Service
@RequiredArgsConstructor
public class BatteryInfoServiceImpl implements BatteryInfoService {
  private final BatteryRepository batteryRepository;

  /**
   * Adds a list of batteries to the repository.
   *
   * @param batteries the list of Battery objects to be added.
   * @return the list of saved Battery objects.
   */
  @Override
  public List<Battery> addBatteries(List<Battery> batteries) {
    return batteryRepository.saveAll(batteries);
  }

  /**
   * Retrieves a list of batteries within a specified postcode range.
   *
   * @param startPostcode the starting postcode of the range (inclusive).
   * @param endPostcode   the ending postcode of the range (inclusive).
   * @return a list of BatteryResponse objects that fall within the specified postcode range.
   */
  @Override
  public List<BatteryResponse> getBatteriesByPostcodeRange(String startPostcode, String endPostcode) {
    List<Battery> batteries = batteryRepository.findByPostcodeBetween(startPostcode, endPostcode).stream()
            .sorted((b1, b2) -> b1.getPostcode().compareToIgnoreCase(b2.getPostcode()))
            .collect(Collectors.toList());

    Map<String, List<Battery>> groupedByName = batteries.stream()
            .collect(Collectors.groupingBy(Battery::getBatteryName));
    List<BatteryResponse> responses = groupedByName.entrySet().stream()
            .map(entry -> {
              String batteryName = entry.getKey();
              List<Battery> sameNameBatteries = entry.getValue();
              BatteryStatistics overallStatistics = calculateBatteryStatistics(sameNameBatteries, batteries.size());
              String representativePostcode = sameNameBatteries.get(0).getPostcode();
              return new BatteryResponse(
                      batteryName,
                      representativePostcode,
                      sameNameBatteries.size(),
                      overallStatistics
              );
            })
            .collect(Collectors.toList());
    responses.sort((r1, r2) -> r1.getPostcode().compareToIgnoreCase(r2.getPostcode()));

    return responses;
  }

  /**
   * Calculates battery statistics for a list of batteries with the same name.
   *
   * @param sameNameBatteries the list of batteries with the same name.
   * @param totalBatteries    the total number of batteries.
   * @return the calculated BatteryStatistics object.
   */
  @Override
  public BatteryStatistics calculateBatteryStatistics(List<Battery> sameNameBatteries, int totalBatteries) {
    int totalWattCapacity = sameNameBatteries.stream().mapToInt(Battery::getWattCapacity).sum();
    double averageWattCapacity = totalBatteries > 0 ? (double) totalWattCapacity / totalBatteries : 0;
    return new BatteryStatistics(totalWattCapacity, averageWattCapacity);
  }
}
