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

    public Client updateFull(Client client) {
        if(validateFields(client)) {
            if (client.getIdClient() != null) {
                Optional<Client> clientFind = getclientId(client.getIdClient());
                if (!clientFind.isEmpty()) {
                    if (client.getName() != null) {
                        clientFind.get().setName(client.getName());
                    }
                    if (client.getAge() != null) {
                        clientFind.get().setAge(client.getAge());
                    }
                    if (client.getPassword() != null) {
                        clientFind.get().setPassword(client.getPassword());
                    }
                    return clientRepository.saveClient(clientFind.get());
                }
            }
            return client;
        }
        return client;
    }

       
    public boolean deleteClient(int id) {
        Boolean result= getclientId(id).map(element -> {
            clientRepository.delete(element);
            return true;
        }).orElse(false);
        return result;
    }

    public boolean validateFields(Client client){
        return (client.getName().length()<=250 && client.getEmail().length()<=45 && client.getPassword().length()<=45
        && (client.getAge()>0 && client.getAge()<=100)
        );
    }

}
