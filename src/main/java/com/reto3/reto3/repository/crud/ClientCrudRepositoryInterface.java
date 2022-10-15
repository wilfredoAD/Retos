package com.reto3.reto3.repository.crud;

import org.springframework.data.repository.CrudRepository;
import com.reto3.reto3.model.Client;

public interface ClientCrudRepositoryInterface extends CrudRepository <Client,Integer> {
    
}
