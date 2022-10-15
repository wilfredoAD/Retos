package com.reto3.reto3.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.reto3.reto3.model.Client;
import com.reto3.reto3.repository.crud.ClientCrudRepositoryInterface;

@Repository
public class ClientRepository {

    @Autowired
    public ClientCrudRepositoryInterface clientCrudRepositoryInterface;

    public List<Client> getClientFull() {
        return (List<Client>) clientCrudRepositoryInterface.findAll();
    }

    public Optional<Client> getClientId(int idClient) {
        return clientCrudRepositoryInterface.findById(idClient);
    }

    public Client saveClient(Client client) {
        return clientCrudRepositoryInterface.save(client);

    }

}
