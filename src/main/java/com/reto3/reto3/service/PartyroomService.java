package com.reto3.reto3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reto3.reto3.model.Partyroom;
import com.reto3.reto3.repository.PartyroomRepository;

@Service
public class PartyroomService {
    

    @Autowired
    private PartyroomRepository partyroomRepository;

    public List<Partyroom> getPartyroomsFull(){
        return partyroomRepository.getPartyroomFull();
    } 

    public Optional<Partyroom>getPartyroomId(int idPartyroom){
        return partyroomRepository.getPartyroomId(idPartyroom);
    }

    public Partyroom savePartyroom(Partyroom partyroom){
        if(partyroom.getId()==null){
            return partyroomRepository.savePartyroom(partyroom);
        }else{

            Optional<Partyroom> partyrommAux = partyroomRepository.getPartyroomId(partyroom.getId());
            if(partyrommAux.isEmpty()){
                return partyroomRepository.savePartyroom(partyroom);
            }else{
                return partyroom;
            }
        }

    }
}
