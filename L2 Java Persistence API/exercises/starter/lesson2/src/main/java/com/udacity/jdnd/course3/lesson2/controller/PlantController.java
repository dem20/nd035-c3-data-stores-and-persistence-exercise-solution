package com.udacity.jdnd.course3.lesson2.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.udacity.jdnd.course3.lesson2.data.Plant;
import com.udacity.jdnd.course3.lesson2.data.PlantDTO;
import com.udacity.jdnd.course3.lesson2.service.PlantService;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/plant")
public class PlantController {

    @Autowired
    private PlantService plantService;

    @GetMapping
    public List<Plant> getAllPlants() {
        return plantService.getAllPlants();
    }

    public PlantDTO getPlantDTO(String name){
        return convertPlantToPlantDTO(plantService.getPlantByName(name));
    }

    @JsonView(Views.Public.class)
    public Plant getFilteredPlant(String name){
        return plantService.getPlantByName(name);
    }

    private PlantDTO convertPlantToPlantDTO(Plant plant){
        PlantDTO plantDTO = new PlantDTO();
        BeanUtils.copyProperties(plant, plantDTO);
        return plantDTO;
    }

    public Long save(Plant plant) {
        return plantService.save(plant);
    }

     @GetMapping("/delivered/{plantId}")
    public boolean isPlantDelivered(@PathVariable Long plantId) {
        return plantService.isPlantDelivered(plantId);
    }

    @GetMapping("/cheaper/{price}")
    @JsonView(Views.Public.class)
    public List<Plant> findPlantsCheaperThan(@PathVariable BigDecimal price) {
        return plantService.findPlantsCheaperThan(price);
    }
}
