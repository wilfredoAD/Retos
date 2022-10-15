package com.reto3.reto3.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.reto3.reto3.model.Client;
import com.reto3.reto3.service.ClientService;

@RestController
@RequestMapping("/api/Client")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.DELETE, RequestMethod.POST,
        RequestMethod.PUT })

public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping("/all")
    public List<Client> getclientFull() {
        return clientService.getclientFull();
    }

    @GetMapping("/{id}")
    public Optional<Client> getclientId(@PathVariable("id") int idclient) {
        return clientService.getclientId(idclient);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Client saveClient(@RequestBody Client client) {
        return clientService.saveClient(client);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Client updateFull(@RequestBody Client client) {
        return clientService.updateFull(client);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteClient(@PathVariable("id") int id) {
        return clientService.deleteClient(id);
    }

}
