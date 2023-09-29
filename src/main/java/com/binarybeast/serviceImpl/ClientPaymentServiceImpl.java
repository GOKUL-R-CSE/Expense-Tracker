package com.binarybeast.serviceImpl;

import com.binarybeast.entity.Clients;
import com.binarybeast.entity.PaymentMethods;
import com.binarybeast.repository.ClientRepository;
import com.binarybeast.repository.PaymentMethodRepository;
import com.binarybeast.service.ClientPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ClientPaymentServiceImpl implements ClientPaymentService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private PaymentMethodRepository paymentMethodRepository;

    @Override
    public void addClientPayment() {

        List<PaymentMethods> payment = paymentMethodRepository.findAll();
        List<Clients> clients = clientRepository.findAll();

        for(PaymentMethods pay: payment){
            for(Clients cli: clients){
                if(pay.getUserName().equalsIgnoreCase(cli.getUserName())){
                    pay.getClients().add(cli);
                }
            }
        }
        for(PaymentMethods pay: payment)
            paymentMethodRepository.save(pay);

    }
}
