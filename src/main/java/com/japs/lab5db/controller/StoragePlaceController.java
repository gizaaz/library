package com.japs.lab5db.controller;


import com.japs.lab5db.model.StoragePlace;
import com.japs.lab5db.repository.StoragePlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/storageplace")
public class StoragePlaceController {
    //@Autowired
    //ReservationOrganizationServiceImpl organizationService;

    @Autowired
    StoragePlaceRepository storagePlaceRepository;

    @RequestMapping("/get")
    public List<StoragePlace> getStoragePlace()  {
        //return organizationService.getReservationOrganizations();
        return storagePlaceRepository.findAll();
    }

    @PostMapping("/insert")
    public StoragePlace insertStoragePlace(@RequestBody StoragePlace storagePlace){
        //return organizationService.insertReservationOrganization(organization);
        return storagePlaceRepository.save(storagePlace);
    }
    @RequestMapping("/update")
    public StoragePlace updateStoragePlace(@RequestBody StoragePlace storagePlace,@RequestParam("id")int id)  {
        storagePlace.setIdStoragePlace(id);
        return storagePlaceRepository.save(storagePlace);
        //return organizationService.updateReservationOrganization(organization);
    }

    @RequestMapping("/del")
    public void deleteStoragePlace(@RequestParam("id")int id)  {
        //organizationService.deleteReservationOrganization(id);
        storagePlaceRepository.deleteById(id);
    }
}
