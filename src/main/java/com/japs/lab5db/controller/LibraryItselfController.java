package com.japs.lab5db.controller;

import com.japs.lab5db.model.LibraryItself;
import com.japs.lab5db.repository.LibraryItselfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libraryitself")
public class LibraryItselfController {

    @Autowired
    LibraryItselfRepository libraryItselfRepository;

    @RequestMapping("/get")
    public List<LibraryItself> getLibraryItself()  {
        //return buildingService.getBuildings();
        return libraryItselfRepository.findAll();
    }

    @PostMapping("/insert")
    public LibraryItself insertLibraryItself( @RequestBody LibraryItself libraryItself){
        //return buildingService.insertBuilding(book);
        return libraryItselfRepository.save(libraryItself);
    }
    @RequestMapping("/update")
    public LibraryItself updateLibraryItself(@RequestBody LibraryItself libraryItself,@RequestParam("id")int id)  {
        libraryItself.setIdLibraryItself(id);
        return libraryItselfRepository.save(libraryItself);
        //return buildingService.updateBuilding(book);
    }

    @RequestMapping("/del")
    public void deleteLibraryItself(@RequestParam("id")int id)  {
        //buildingService.deleteBuilding(id);
        libraryItselfRepository.deleteById(id);
    }

}
