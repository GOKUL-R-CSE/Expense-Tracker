package com.binarybeast.controller;

import com.binarybeast.service.ClientPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientPaymentController {

    @Autowired
    private ClientPaymentService service;

    @PostMapping("/addClientPayment")
    public ResponseEntity<String> addClientPayment(){
        try {
            service.addClientPayment();
            return new ResponseEntity<String>("Payment added successfully", HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<String>("Invalid payment operation", HttpStatus.BAD_REQUEST);
        }
    }

}
