package com.binarybeast.service;

import java.util.List;
import java.util.Optional;

import com.binarybeast.entity.Transactions;

public interface TransactionService {

    List<Transactions> getTransactions();

    Optional<Transactions> getTransaction(Long id);

    Optional<List<Transactions>> getTransaction(String name);

    Transactions addTransaction(Transactions transaction);

    void deleteTransaction(Long id);

    Transactions updateTransaction(Long id, Transactions transaction);

}
