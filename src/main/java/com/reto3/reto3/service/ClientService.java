package com.reto3.reto3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reto3.reto3.model.Client;
import com.reto3.reto3.repository.ClientRepository;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getclientFull() {
        return clientRepository.getClientFull();
    }

    public Optional<Client> getclientId(int idclient) {
        return clientRepository.getClientId(idclient);
    }

    public Client saveClient(Client client) {

        if (client.getIdClient() == null) {
            return clientRepository.saveClient(client);
        }else{
            Optional<Client> clientAux = clientRepository.getClientId(client.getIdClient());
            if (clientAux.isEmpty()){
                return clientRepository.saveClient(client);
            }else{
                return client;
            }
        } 

    }

}
