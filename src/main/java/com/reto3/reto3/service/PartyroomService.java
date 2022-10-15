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

    public List<Partyroom> getPartyroomsFull() {
        return partyroomRepository.getPartyroomFull();
    }

    public Optional<Partyroom> getPartyroomId(int id) {
        return partyroomRepository.getPartyroomId(id);
    }

    public Partyroom savePartyroom(Partyroom partyroom) {
        if (partyroom.getId() == null) {
            return partyroomRepository.savePartyroom(partyroom);
        } else {

            Optional<Partyroom> partyrommAux = partyroomRepository.getPartyroomId(partyroom.getId());
            if (partyrommAux.isEmpty()) {
                return partyroomRepository.savePartyroom(partyroom);
            } else {
                return partyroom;
            }
        }

    }

    public Partyroom updateFull(Partyroom partyroom) {
        if (validateFields(partyroom)) {
            if (partyroom.getId() != null) {
                Optional<Partyroom> partyroomFind = getPartyroomId(partyroom.getId());
                if (!partyroomFind.isEmpty()) {
                    if (partyroom.getName() != null) {
                        partyroomFind.get().setName(partyroom.getName());
                    }

                    if (partyroom.getOwner() != null) {
                        partyroomFind.get().setOwner(partyroom.getOwner());
                    }
                    if (partyroom.getCapacity() != null) {
                        partyroomFind.get().setCapacity(partyroom.getCapacity());
                    }
                    if (partyroom.getDescription() != null) {
                        partyroomFind.get().setDescription(partyroom.getDescription());
                    }
                    if (partyroom.getCategory() != null) {
                        partyroomFind.get().setCategory(partyroom.getCategory());
                    }
                    return partyroomRepository.savePartyroom(partyroomFind.get());
                }

            }
            return partyroom;
        }
        return partyroom;
    }

    public boolean deletePartyroom(int partyrommId) {
        Boolean result = getPartyroomId(partyrommId).map(element -> {
            partyroomRepository.delete(element);
            return true;
        }).orElse(false);
        return result;
    }

    public boolean validateFields(Partyroom partyroom) {
        return (partyroom.getName().length() <= 45 && partyroom.getOwner().length() <= 45 &&
        partyroom.getDescription().length() <= 250 );
    }
}
