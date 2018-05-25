package com.japs.lab5db.controller;

import com.japs.lab5db.model.Scientist;
import com.japs.lab5db.repository.ScientistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/scientist")
public class ScientistController {

    @Autowired
    ScientistRepository scientistRepository;

    @RequestMapping("/get")
    public List<Scientist> getScientist()  {
        //return buildingService.getBuildings();
        return scientistRepository.findAll();
    }

    @PostMapping("/insert")
    public Scientist insertScientist(@RequestBody Scientist scientist){
        //return buildingService.insertBuilding(book);
        return scientistRepository.save(scientist);
    }
    @RequestMapping("/update")
    public Scientist updateScientist(@RequestBody Scientist scientist, @RequestParam("id")int id)  {
        scientist.setIdScientist(id);
        return scientistRepository.save(scientist);
        //return buildingService.updateBuilding(book);
    }

    @RequestMapping("/del")
    public void deleteScientist(@RequestParam("id")int id)  {
        //buildingService.deleteBuilding(id);
        scientistRepository.deleteById(id);
    }

}
