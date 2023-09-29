package com.binarybeast.serviceImpl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.binarybeast.entity.Clients;
import com.binarybeast.exception.ResourceAlreadyExistsException;
import com.binarybeast.exception.ResourceNotFoundException;
import com.binarybeast.repository.ClientRepository;
import com.binarybeast.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService{

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Clients addClient(Clients clients) {
        Optional<Clients> cli = clientRepository.findByEmail(clients.getEmail());
        if(cli.isPresent()) {
            throw new ResourceAlreadyExistsException("Client", "specified email");
        }
        clients.setDateOfRegistration(LocalDateTime.now());
        return clientRepository.save(clients);
    }

    @Override
    public List<Clients> getClients() {
        return clientRepository.findAll();
    }

    @Override
    public Optional<Clients> getClient(Long id) {
        Optional<Clients> cli = clientRepository.findByClientId(id);
        if(cli.isPresent()) {
            return clientRepository.findByClientId(id);
        }
        else
            throw new ResourceNotFoundException("Client", "specified id");
    }

    @Override
    @Transactional
    public void deleteClient(Long id) {
        Optional<Clients> cli = clientRepository.findByClientId(id);
        if(cli.isPresent()) {
            clientRepository.deleteByClientId(id);
        }
        else {
            throw new ResourceNotFoundException("Client", "specified id");
        }
    }

    @Override
    public Clients updateClient(Long id, Clients clients) {
        Clients cli = clientRepository.findByClientId(id).orElseThrow(() -> new ResourceNotFoundException("Client", "specified id"));
        if(Objects.nonNull(clients.getFirstName()) && !"".equals(clients.getFirstName())){
            cli.setFirstName(clients.getFirstName());
        }
        if(Objects.nonNull(clients.getLastName()) && !"".equals(clients.getLastName())){
            cli.setLastName(clients.getLastName());
        }
        if(Objects.nonNull(clients.getEmail()) && !"".equals(clients.getEmail())){
            cli.setEmail(clients.getEmail());
        }
        if(Objects.nonNull(clients.getUserName()) && !"".equals(clients.getUserName())){
            cli.setUserName(clients.getUserName());
        }
        clientRepository.save(cli);
        return cli;
    }


}
