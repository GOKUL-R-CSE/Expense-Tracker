package com.binarybeast.serviceImpl;

import com.binarybeast.entity.Clients;
import com.binarybeast.entity.Transactions;
import com.binarybeast.exception.ResourceNotFoundException;
import com.binarybeast.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.binarybeast.repository.ClientRepository;
import com.binarybeast.repository.TransactionRepository;
import com.binarybeast.service.ClientTransactionService;

import java.util.List;
import java.util.Optional;

@Service
public class ClientTransactionServiceImpl implements ClientTransactionService{

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private TransactionRepository transactionRepository;


    @Override
    public void addTransaction() {
//		Transactions trans = transactionRepository.findByTransactionId(id)
//				.orElseThrow(() -> new ResourceNotFoundException("Transaction", "specified id"));
//
//		Optional<Clients> client = clientRepository.findByUserName(userName);
//
//			if (client.isPresent()) {
//				if (trans.getUserName().equalsIgnoreCase(userName)) {
//					boolean add = trans.getClients().add(client.get());
//					transactionRepository.save(trans);
//				}
//			} else {
//				throw new RuntimeException("Invalid transaction operation");
//			}
//		for(Clients cli: clients){
//			trans.getClients().add(cli);
//		}
//		transactionRepository.save(trans);

        List<Transactions> trans = transactionRepository.findAll();
        List<Clients> clients = clientRepository.findAll();

        for(Transactions tran: trans){
            for(Clients cli: clients){
                if(tran.getUserName().equalsIgnoreCase(cli.getUserName())){
                    tran.getClients().add(cli);
                }
            }
        }
        for(Transactions tran: trans)
            transactionRepository.save(tran);
    }
}
