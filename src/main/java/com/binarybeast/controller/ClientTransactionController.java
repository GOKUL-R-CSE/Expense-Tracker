package com.binarybeast.controller;

import com.binarybeast.service.ClientTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientTransactionController {

    @Autowired
    private ClientTransactionService service;

    @PostMapping("/addClientTrans")
    public ResponseEntity<String> addTransaction(
    ){
        try {
            service.addTransaction();
            return new ResponseEntity<String>("Transaction added successfully", HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<String>("Invalid transaction to add", HttpStatus.BAD_REQUEST);
        }
    }
}
