package com.reto3.reto3.repository.crud;

import org.springframework.data.repository.CrudRepository;

import com.reto3.reto3.model.Message;

public interface MessageCrudRepositoryInterface extends CrudRepository<Message,Integer>  {
    
}
