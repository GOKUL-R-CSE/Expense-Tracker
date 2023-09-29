package com.binarybeast.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.binarybeast.entity.PaymentMethods;
import com.binarybeast.service.PaymentMethodService;

@RestController
public class PaymentMethodController {

    @Autowired
    private PaymentMethodService paymentService;

    @GetMapping("/getPayments")
    public ResponseEntity<List<PaymentMethods>> getPayments(){
        return new ResponseEntity<List<PaymentMethods>>(paymentService.getPayments(), HttpStatus.FOUND);
    }

    @GetMapping("/getPayment/{id}")
    public Optional<PaymentMethods> getPayment(
            @PathVariable(name = "id") Long id
    ){
        return paymentService.getPayment(id);
    }

    @GetMapping("/getPayment/user/{name}")
    public Optional<List<PaymentMethods>> getPayment(
            @PathVariable(name = "name") String name
    ){
        return paymentService.getPayment(name);
    }

    @GetMapping("/getPayment/mode/{name}")
    public Optional<List<PaymentMethods>> getPaymentByMode(
            @PathVariable(name = "name") String name
    ){
        return paymentService.getPaymentByMode(name);
    }

    @DeleteMapping("/deletePayment/{id}")
    public String deletePayment(
            @PathVariable(name = "id") Long id
    ) {
        paymentService.deletePayment(id);
        return "Payment deleted successfully";
    }

    @PostMapping("/addPayment")
    public ResponseEntity<PaymentMethods> addPayment(
            @Validated
            @RequestBody PaymentMethods payment
    ){
        return new ResponseEntity<PaymentMethods>(paymentService.addPayment(payment), HttpStatus.CREATED);
    }

    @PutMapping("/updatePayment/{id}")
    public ResponseEntity<PaymentMethods> updatePayment(
            @PathVariable(name = "id") Long id,
            @RequestBody PaymentMethods payment
    ){
        return new ResponseEntity<PaymentMethods>(paymentService.updatePayment(id, payment), HttpStatus.ACCEPTED);
    }
}
