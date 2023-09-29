package com.binarybeast.controller;

import java.util.List;
import java.util.Optional;

import org.ff4j.FF4j;
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

import com.binarybeast.entity.Transactions;
import com.binarybeast.service.TransactionService;

@RestController
public class TransactionController {

//    @Autowired
//    private FF4j ff4j;

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/getTransactions")
    public ResponseEntity<List<Transactions>> getTransactions(){
        return new ResponseEntity<List<Transactions>>(transactionService.getTransactions(), HttpStatus.FOUND);
    }

    @GetMapping("/getTransaction/{id}")
    public Optional<Transactions> getTransaction(
            @PathVariable(name = "id") Long id
    ){
        return transactionService.getTransaction(id);
    }

    @GetMapping("/getTransaction/user/{name}")
    public Optional<List<Transactions>>getTransaction(
            @PathVariable(name = "name") String name
    ){
        return transactionService.getTransaction(name);
    }

    @PostMapping("/addTransaction")
    public ResponseEntity<Transactions> addTransaction(
            @Validated
            @RequestBody Transactions transaction
    ){
        return new ResponseEntity<Transactions>(transactionService.addTransaction(transaction), HttpStatus.OK);
    }

    @DeleteMapping("/deleteTransaction/{id}")
    public String deleteTransaction(
            @PathVariable(name = "id") Long id
    ) {
        transactionService.deleteTransaction(id);
        return "Transaction deleted successfully";
    }

    @PutMapping("/updateTransaction/{id}")
    public ResponseEntity<Transactions> updateTransaction(
            @PathVariable(name = "id") Long id,
            @RequestBody Transactions transaction
    ) {
//        if(ff4j.check("edit_enabled"))
            return new ResponseEntity<Transactions>(transactionService.updateTransaction(id, transaction), HttpStatus.OK);
//        else
//            return new ResponseEntity<Transactions>(transaction,HttpStatus.BAD_REQUEST);
    }
}
