package com.reto3.reto3.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.reto3.reto3.model.Partyroom;
import com.reto3.reto3.repository.crud.PartyroomCrudRepositoryInterface;

@Repository
public class PartyroomRepository {

    @Autowired
    public PartyroomCrudRepositoryInterface partyroomCrudRepositoryInterface;

    public List<Partyroom> getPartyroomFull() {
        return (List<Partyroom>) partyroomCrudRepositoryInterface.findAll();
    }

    public Optional<Partyroom> getPartyroomId(int idPartyroom) {
        return partyroomCrudRepositoryInterface.findById(idPartyroom);
    }

    public Partyroom savePartyroom(Partyroom partyroom) {
        return partyroomCrudRepositoryInterface.save(partyroom);
    }

    public void delete(Partyroom partyroom) {
        partyroomCrudRepositoryInterface.delete(partyroom);
    }
}
