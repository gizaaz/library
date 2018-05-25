package com.japs.lab5db.controller;

import com.japs.lab5db.model.Librarian;
import com.japs.lab5db.repository.LibrarianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/librarian")
public class LibrarianController {

    //@Autowired
    //ClassBuildingServiceImpl organizationService;

    @Autowired
    LibrarianRepository librarianRepository;

    @RequestMapping("/get")
    public List<Librarian> getLibrarian()  {
        //return organizationService.getClassBuildings();
        return librarianRepository.findAll();
    }

    @PostMapping("/insert")
    public Librarian insertLibrarian(@RequestBody Librarian librarian){
        //return organizationService.insertClassBuilding(organization);
        return librarianRepository.save(librarian);
    }
    @RequestMapping("/update")
    public Librarian updateLibrarian(@RequestBody Librarian librarian, @RequestParam("id")int id)  {
        librarian.setIdLibrarian(id);
        return librarianRepository.save(librarian);
        //return organizationService.updateClassBuilding(organization);
    }

    @RequestMapping("/del")
    public void deleteLibrarian(@RequestParam("id")int id)  {
        //organizationService.deleteClassBuilding(id);
        librarianRepository.deleteById(id);
    }
}
