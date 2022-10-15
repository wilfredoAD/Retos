package com.reto3.reto3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reto3.reto3.model.Message;
import com.reto3.reto3.repository.MessageRepository;

@Service
public class MessageService {
    

    @Autowired
    private MessageRepository messageRepository; 

    public List<Message> getmessageFull(){
        return messageRepository.getMessageFull();
    }

    public Optional<Message> getMessageId(int idMessage){
        return messageRepository.getMessageId(idMessage);        
    }

    public Message saveMessage(Message message){
        if(message.getIdMessage()==null){
            return messageRepository.saveMessageId(message);            
        }else{
            Optional<Message>messageAux = messageRepository.getMessageId(message.getIdMessage());
            if(messageAux.isEmpty()){
                return messageRepository.saveMessageId(message);
            }else{
                return message;
            }
        }        
    } 


}
