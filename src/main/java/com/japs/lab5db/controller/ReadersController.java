package com.japs.lab5db.controller;

import com.japs.lab5db.model.Readers;
import com.japs.lab5db.repository.ReadersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/readers")
public class ReadersController {
    //@Autowired
    //CustomerServiceImpl organizationService;

    @Autowired
    ReadersRepository readersRepository;

    @RequestMapping("/get")
    public List<Readers> getReaders()  {
        //return organizationService.getCustomers();
        return readersRepository.findAll();
    }

    @PostMapping("/insert")
    public Readers insertReaders(@RequestBody Readers readers){
        //return organizationService.insertCustomer(organization);
        return readersRepository.save(readers);
    }
    @RequestMapping("/update")
    public Readers updateReaders(@RequestBody Readers readers, @RequestParam("id")int id)  {
        readers.setIdReaders(id);
        return readersRepository.save(readers);
        //return organizationService.updateCustomer(organization);
    }

    @RequestMapping("/del")
    public void deleteReaders(@RequestParam("id")int id)  {
        //organizationService.deleteCustomer(id);
        readersRepository.deleteById(id);
    }
}
