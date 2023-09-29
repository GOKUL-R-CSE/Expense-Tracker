package com.binarybeast.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.binarybeast.entity.Transactions;

public interface TransactionRepository extends JpaRepository<Transactions, String>{

    public Optional<Transactions> findByTransactionId(Long id);

    public Optional<List<Transactions>> findAllByUserNameIgnoreCase(String name);

    public void deleteByTransactionId(Long id);

}
