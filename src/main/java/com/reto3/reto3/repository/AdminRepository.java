package com.reto3.reto3.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.reto3.reto3.model.Administrators;
import com.reto3.reto3.repository.crud.AdminCrudRepositoryInterface;

@Repository
public class AdminRepository {

    @Autowired
    public AdminCrudRepositoryInterface adminCrudRepositoryInterface;

    public List<Administrators> getAdminFull() {
        return (List<Administrators>) adminCrudRepositoryInterface.findAll();
    }

    public Optional<Administrators> getAdminId(int idAdmin) {
        return adminCrudRepositoryInterface.findById(idAdmin);
    }

    public Administrators saveAdministrators(Administrators administrators){
        return adminCrudRepositoryInterface.save(administrators);
    }

}
