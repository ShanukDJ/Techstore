package com.techstore.paymentsapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PaymentsController {

    @Autowired
    private PaymentsRepository PaymentsRepository;



    /*@GetMapping("/users/{id}")
    public @ResponseBody User getUser(@PathVariable String id) {
        return userRepository.findById(Integer.parseInt(id)).get();
    }
    */

    @GetMapping("/payments")
    public @ResponseBody
    List<Payments> getAllPayments() {
        List<Payments> payments = new ArrayList<>();
        PaymentsRepository.findAll().forEach(payments::add);
        return payments;
    }

    @PostMapping("/payments")
    public @ResponseBody Payments createPayment(@RequestBody  Payments payments) {
        return PaymentsRepository.save(payments);
    }

    @DeleteMapping("/payments/{paymentId}")
    public @ResponseBody void deletePayments(@PathVariable String paymentId) {
        PaymentsRepository.deleteById(Integer.parseInt(paymentId));
    }

    @PutMapping("/payments/{paymentId}")
    public @ResponseBody
    Payments UpdatePayments(@RequestBody Payments payments) {
        return PaymentsRepository.save(payments);
    }
}














