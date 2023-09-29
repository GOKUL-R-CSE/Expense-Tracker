package com.binarybeast.service;

import java.util.List;
import java.util.Optional;

import com.binarybeast.entity.Clients;

public interface ClientService {

    Clients addClient(Clients clients);

    List<Clients> getClients();

    Optional<Clients> getClient(Long id);

    void deleteClient(Long id);

    Clients updateClient(Long id, Clients clients);

}
