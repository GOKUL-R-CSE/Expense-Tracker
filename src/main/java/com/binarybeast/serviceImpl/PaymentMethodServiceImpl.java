package com.binarybeast.serviceImpl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.binarybeast.entity.PaymentMethods;
import com.binarybeast.exception.ResourceNotFoundException;
import com.binarybeast.repository.PaymentMethodRepository;
import com.binarybeast.service.PaymentMethodService;

@Service
public class PaymentMethodServiceImpl implements PaymentMethodService{

    @Autowired
    private PaymentMethodRepository paymentRepository;

    @Override
    public List<PaymentMethods> getPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public Optional<PaymentMethods> getPayment(Long id) {
        Optional<PaymentMethods> payment = paymentRepository.findById(id);
        if(payment.isEmpty()) {
            throw new ResourceNotFoundException("Payment", "specified id");
        }
        return payment;
    }

    @Override
    public Optional<List<PaymentMethods>> getPayment(String name) {
        Optional<List<PaymentMethods>> payments = paymentRepository.findByUserNameIgnoreCase(name);
        if(payments.isEmpty()) {
            throw new ResourceNotFoundException("Payments", "specified user name");
        }
        return payments;
    }

    @Override
    @Transactional
    public void deletePayment(Long id) {
        paymentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Payment", "specified id"));
        paymentRepository.deleteById(id);
    }

    @Override
    public PaymentMethods addPayment(PaymentMethods payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public PaymentMethods updatePayment(Long id, PaymentMethods payment) {
        PaymentMethods pay = paymentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Payment", "specified id"));
        if(Objects.nonNull(payment.getDescription()) && !"".equals(payment.getDescription())){
            pay.setDescription(payment.getDescription());
        }
        paymentRepository.save(pay);
        return pay;
    }

    @Override
    public Optional<List<PaymentMethods>> getPaymentByMode(String name) {
        Optional<List<PaymentMethods>> payments = paymentRepository.findByNameIgnoreCase(name);
        if(payments.isEmpty()) {
            throw new ResourceNotFoundException("Payments", "specified user name");
        }
        return payments;
    }

}
