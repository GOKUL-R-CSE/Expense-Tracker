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

import com.binarybeast.entity.Clients;
import com.binarybeast.service.ClientService;

@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping("/addClient")
    public ResponseEntity<Clients> addClient(
            @Validated
            @RequestBody Clients clients
    ){
        Clients cli = clientService.addClient(clients);
        return new ResponseEntity<Clients>(cli,HttpStatus.CREATED);
    }

    @GetMapping("/clients")
    public ResponseEntity<List<Clients>> getClients(){
        return new ResponseEntity<List<Clients>>(clientService.getClients(), HttpStatus.FOUND);
    }

    @GetMapping("/client/{id}")
    public Optional<Clients> getClient(
            @PathVariable(name = "id") Long id
    ){
        return clientService.getClient(id);
    }

    @DeleteMapping("/deleteClient/{id}")
    public String deleteClient(
            @PathVariable(name = "id") Long id
    ) {
        clientService.deleteClient(id);
        return "Client deleted successfully";
    }

    @PutMapping("updateClient/{id}")
    public ResponseEntity<Clients> updateClient(
            @PathVariable(name = "id") Long id,
            @RequestBody Clients clients
    ){
        return new ResponseEntity<Clients>(clientService.updateClient(id, clients), HttpStatus.ACCEPTED);
    }

}
