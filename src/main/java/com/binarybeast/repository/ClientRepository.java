package com.binarybeast.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.binarybeast.entity.Clients;

public interface ClientRepository extends JpaRepository<Clients, String>{

    public Optional<Clients> findByClientId(Long id);

    public void deleteByClientId(Long Clientd);

    public Optional<Clients> findByEmail(String email);

    Optional<Clients> findByUserName(String userName);
}
