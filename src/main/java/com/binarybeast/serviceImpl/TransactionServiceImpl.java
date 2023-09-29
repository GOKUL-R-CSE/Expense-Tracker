package com.binarybeast.serviceImpl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.binarybeast.entity.Transactions;
import com.binarybeast.exception.ResourceAlreadyExistsException;
import com.binarybeast.exception.ResourceNotFoundException;
import com.binarybeast.repository.TransactionRepository;
import com.binarybeast.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService{

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public List<Transactions> getTransactions() {
        return transactionRepository.findAll();
    }

    @Override
    public Optional<Transactions> getTransaction(Long id) {
        Optional<Transactions> trans = transactionRepository.findByTransactionId(id);
        if(trans.isEmpty()) {
            throw new ResourceNotFoundException("Transaction", "specified id");
        }
        return trans;
    }

    @Override
    public Optional<List<Transactions>> getTransaction(String name) {
        Optional<List<Transactions>> trans = transactionRepository.findAllByUserNameIgnoreCase(name);
        if(trans.isEmpty()) {
            throw new ResourceNotFoundException("Tranaction", "specified user name");
        }
        return trans;
    }

    @Override
    public Transactions addTransaction(Transactions transaction) {
        Optional<Transactions> trans = transactionRepository.findByTransactionId(transaction.getTransactionId());
        if(trans.isPresent()) {
            throw new ResourceAlreadyExistsException("Transaction", "specified id");
        }
        transaction.setDateTime(LocalDateTime.now());
        transactionRepository.save(transaction);
        return transaction;
    }

    @Override
    @Transactional
    public void deleteTransaction(Long id) {
        transactionRepository.findByTransactionId(id).orElseThrow(() -> new ResourceNotFoundException("Transaction", "specified id"));
        transactionRepository.deleteByTransactionId(id);
    }

    @Override
    public Transactions updateTransaction(Long id, Transactions transaction) {
        Transactions trans = transactionRepository.findByTransactionId(id).orElseThrow(() -> new ResourceNotFoundException("Transaction", "specified id"));
        if(Objects.nonNull(transaction.getDescription()) && !"".equals(transaction.getDescription())){
            trans.setDescription(transaction.getDescription());
        }
        transactionRepository.save(trans);
        return trans;
    }

}
