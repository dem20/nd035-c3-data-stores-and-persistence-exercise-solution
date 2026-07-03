package com.udacity.jdnd.course3.lesson2.service;

import com.udacity.jdnd.course3.lesson2.data.Plant;
import com.udacity.jdnd.course3.lesson2.data.PlantRepository;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlantService {

    @Autowired
    PlantRepository plantRepository;

    public List<Plant> getAllPlants() {
        return plantRepository.findAll();
    }

    public Plant getPlantByName(String name){
        return new Plant();
    }

    public Long save(Plant plant) {
        return plantRepository.save(plant).getId();
    }

    public boolean isPlantDelivered(Long plantId) {
        return plantRepository.existsByIdAndDeliveryCompletedTrue(plantId);
    }

    public List<Plant> findPlantsCheaperThan(BigDecimal price) {
        return plantRepository.findByPriceLessThan(price);
    }
}
