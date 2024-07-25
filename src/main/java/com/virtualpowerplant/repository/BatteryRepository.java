package com.virtualpowerplant.repository;

import com.virtualpowerplant.model.Battery;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface BatteryRepository extends MongoRepository<Battery, String> {
  @Query("{ 'postcode' : { $gte: ?0, $lte: ?1 } }")
  List<Battery> findByPostcodeBetween(String startPostcode, String endPostcode);
}
