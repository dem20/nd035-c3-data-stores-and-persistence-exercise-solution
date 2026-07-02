package com.udacity.jdnd.course3.lesson1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.udacity.jdnd.course3.lesson1.service.PlantService;
import com.fasterxml.jackson.annotation.JsonView;
import com.udacity.jdnd.course3.lesson1.data.Plant;
import com.udacity.jdnd.course3.lesson1.data.dto.PlantDTO;
import com.udacity.jdnd.course3.lesson1.data.view.Views;

@RestController
@RequestMapping("/plant")
public class PlantController {

   @Autowired
   private PlantService plantService;

   public PlantDTO getPlantDTO(String name){
       Plant plant = plantService.getPlantByName(name);
       PlantDTO plantDTO = new PlantDTO();
       plantDTO.setName(plant.getName());
       plantDTO.setPrice(plant.getPrice());
       return plantDTO;
   }

   @JsonView(Views.Public.class)
   public Plant getFilteredPlant(String name){
       return plantService.getPlantByName(name);
   }
}
