package com.japs.lab5db.controller;

import com.japs.lab5db.model.Students;
import com.japs.lab5db.repository.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentsController {

    @Autowired
    StudentsRepository studentsRepository;

    @RequestMapping("/get")
    public List<Students> getStudents()  {
        //return buildingService.getBuildings();
        return studentsRepository.findAll();
    }

    @PostMapping("/insert")
    public Students insertStudents(@RequestBody Students students){
        //return buildingService.insertBuilding(book);
        return studentsRepository.save(students);
    }
    @RequestMapping("/update")
    public Students updateStudents(@RequestBody Students students, @RequestParam("id")int id)  {
        students.setIdStudents(id);
        return studentsRepository.save(students);
        //return buildingService.updateBuilding(book);
    }

    @RequestMapping("/del")
    public void deleteStudents(@RequestParam("id")int id)  {
        //buildingService.deleteBuilding(id);
        studentsRepository.deleteById(id);
    }

}
