package com.udacity.jdnd.course3.lesson1.service;
import org.springframework.stereotype.Service;
import com.udacity.jdnd.course3.lesson1.data.Plant;

@Service
public class PlantService {
   public Plant getPlantByName(String name){
       return new Plant();
   }
}