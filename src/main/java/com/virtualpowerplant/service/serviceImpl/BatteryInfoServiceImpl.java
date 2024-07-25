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

@Service
@RequiredArgsConstructor
public class BatteryInfoServiceImpl implements BatteryInfoService {
  private final BatteryRepository batteryRepository;

  @Override
  public List<Battery> addBatteries(List<Battery> batteries) {
    return batteryRepository.saveAll(batteries);
  }

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

  @Override
  public BatteryStatistics calculateBatteryStatistics(List<Battery> sameNameBatteries, int totalBatteries) {
    int totalWattCapacity = sameNameBatteries.stream().mapToInt(Battery::getWattCapacity).sum();
    double averageWattCapacity = totalBatteries > 0 ? (double) totalWattCapacity / totalBatteries : 0;
    return new BatteryStatistics(totalWattCapacity, averageWattCapacity);
  }
}
