package com.japs.lab5db.controller;

import com.japs.lab5db.model.Pupil;
import com.japs.lab5db.repository.PupilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pupil")
public class PupilController {

    @Autowired
    PupilRepository pupilRepository;

    @RequestMapping("/get")
    public List<Pupil> getPupil()  {
        //return buildingService.getBuildings();
        return pupilRepository.findAll();
    }

    @PostMapping("/insert")
    public Pupil insertPupil( @RequestBody Pupil pupil){
        //return buildingService.insertBuilding(book);
        return pupilRepository.save(pupil);
    }
    @RequestMapping("/update")
    public Pupil updatePupil(@RequestBody Pupil pupil,@RequestParam("id")int id)  {
        pupil.setIdPupil(id);
        return pupilRepository.save(pupil);
        //return buildingService.updateBuilding(book);
    }

    @RequestMapping("/del")
    public void deletePupil(@RequestParam("id")int id)  {
        //buildingService.deleteBuilding(id);
        pupilRepository.deleteById(id);
    }

}
