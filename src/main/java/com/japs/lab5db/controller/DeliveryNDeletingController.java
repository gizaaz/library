package com.japs.lab5db.controller;

import com.japs.lab5db.model.DeliveryNDeleting;
import com.japs.lab5db.repository.DeliveryNDeletingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/deliveryndeleting")
public class DeliveryNDeletingController {

    @Autowired
    DeliveryNDeletingRepository deliveryNDeletingRepository;

    @RequestMapping("/get")
    public List<DeliveryNDeleting> getDeliveryNDeleting()  {
        //return organizationService.getOrganizations();
        return deliveryNDeletingRepository.findAll();
    }

    @PostMapping("/insert")
    public DeliveryNDeleting insertDeliveryNDeleting( @RequestBody DeliveryNDeleting deliveryNDeleting){
        //return organizationService.insertOrganization(organization);
        return deliveryNDeletingRepository.save(deliveryNDeleting);
    }
    @RequestMapping("/update")
    public DeliveryNDeleting updateOrganization(@RequestBody DeliveryNDeleting deliveryNDeleting,@RequestParam("id")int id)  {
        deliveryNDeleting.setIdDeliveryNDeleting(id);
        return deliveryNDeletingRepository.save(deliveryNDeleting);
        //return organizationService.updateOrganization(organization);
    }

    @RequestMapping("/del")
    public void deleteDeliveryNDeleting(@RequestParam("id")int id)  {
        //organizationService.deleteOrganization(id);
        deliveryNDeletingRepository.deleteById(id);
    }
}
