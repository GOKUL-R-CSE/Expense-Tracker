package com.binarybeast.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.binarybeast.entity.PaymentMethods;

public interface PaymentMethodRepository extends JpaRepository<PaymentMethods, String>{

    Optional<PaymentMethods> findById(Long id);

    Optional<List<PaymentMethods>> findByUserNameIgnoreCase(String name);

    void deleteById(Long id);

    Optional<List<PaymentMethods>> findByNameIgnoreCase(String name);

}
