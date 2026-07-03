package com.udacity.jdnd.course3.lesson2.data;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PlantRepository extends JpaRepository<Plant, Long> {
    boolean existsByIdAndDeliveryCompletedTrue(Long plantId);
    List<Plant> findByPriceLessThan(BigDecimal price);
}
