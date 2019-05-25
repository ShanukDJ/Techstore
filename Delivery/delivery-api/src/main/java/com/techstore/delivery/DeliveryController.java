package com.techstore.delivery;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DeliveryController {

    @Autowired
    private DeliveryRepository DeliveryRepository;



    /*@GetMapping("/users/{id}")
    public @ResponseBody User getUser(@PathVariable String id) {
        return userRepository.findById(Integer.parseInt(id)).get();
    }
    */

    @GetMapping("/deliveries")
    public @ResponseBody
    List<DeliveryForms> getAllDeliveries() {
        List<DeliveryForms> deliveryForms = new ArrayList<>();
        DeliveryRepository.findAll().forEach( deliveryForms::add);
        return  deliveryForms;
    }

    @PostMapping("/deliveries")
    public @ResponseBody DeliveryForms createDForm(@RequestBody  DeliveryForms dforms) {
        return DeliveryRepository.save(dforms);
    }

    @DeleteMapping("/deliveries/{dfId}")
    public @ResponseBody void deleteDforms(@PathVariable String dfId) {
        DeliveryRepository.deleteById(Integer.parseInt(dfId));
    }

    @PutMapping("/deliveries/{dfId}")
    public @ResponseBody
    DeliveryForms UpdateDForms(@RequestBody DeliveryForms dforms) {
        return DeliveryRepository.save(dforms);
    }
}
