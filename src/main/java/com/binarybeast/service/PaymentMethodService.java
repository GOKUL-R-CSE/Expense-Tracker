package com.binarybeast.service;

import java.util.List;
import java.util.Optional;

import com.binarybeast.entity.PaymentMethods;

public interface PaymentMethodService {

    List<PaymentMethods> getPayments();

    Optional<PaymentMethods> getPayment(Long id);

    Optional<List<PaymentMethods>> getPayment(String name);

    void deletePayment(Long id);

    PaymentMethods addPayment(PaymentMethods payment);

    PaymentMethods updatePayment(Long id, PaymentMethods payment);

    Optional<List<PaymentMethods>> getPaymentByMode(String name);

}
