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

    public Message updateFull(Message messages) {
        if (validateFields(messages)) {
            if (messages.getIdMessage() != null) {
                Optional<Message> messageEncontrado = getMessageId(messages.getIdMessage());
                if (!messageEncontrado.isEmpty()) {
                    if (messages.getMessageText() != null) {
                        messageEncontrado.get().setMessageText(messages.getMessageText());
                    }
                    return messageRepository.saveMessageId(messageEncontrado.get());
                }
            }
            return messages;
        }
        return messages;
    }

    public boolean deleteMessage(int messageId) {
        Boolean result=getMessageId(messageId).map(element ->{
            messageRepository.delete(element);
            return true;
        } ).orElse(false);
        return result;
    }
    public boolean validateFields(Message message){

        return (message.getMessageText().length()<=250);
    }
}
