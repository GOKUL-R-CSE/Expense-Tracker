package com.binarybeast.controller;

import com.binarybeast.service.ClientCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientCategoryController {

    @Autowired
    private ClientCategoryService service;

    @PostMapping("/addClientCategory")
    public ResponseEntity<String> addClientCategory(){
        try {
            service.addClientCategory();
            return new ResponseEntity<String>("Category added successfully", HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<String>("Invalid operation", HttpStatus.BAD_REQUEST);
        }
    }
}
