package com.reto3.reto3.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.reto3.reto3.model.Message;
import com.reto3.reto3.repository.crud.MessageCrudRepositoryInterface;


@Repository
public class MessageRepository {
    
    @Autowired
    public MessageCrudRepositoryInterface messageCrudRepositoryInterface;

    public List<Message> getMessageFull(){
        return (List<Message>) messageCrudRepositoryInterface.findAll();
    } 

    public Optional<Message>getMessageId(Integer idMessage){
        return messageCrudRepositoryInterface.findById(idMessage);
    }

    public Message saveMessageId(Message message){
        return messageCrudRepositoryInterface.save(message);
    }

       public void delete(Message message){
        messageCrudRepositoryInterface.delete(message);
    }
}
