package com.reto3.reto3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reto3.reto3.model.Administrators;
import com.reto3.reto3.repository.AdminRepository;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public List<Administrators> getAdminFull() {
        return adminRepository.getAdminFull();
    }

    public Optional<Administrators> getAdminId(int idAdmin) {
        return adminRepository.getAdminId(idAdmin);
    }

    public Administrators saveAdministrators(Administrators administrators) {
        if (administrators.getIdAdmin() == null) {
            return adminRepository.saveAdministrators(administrators);

        } else {
            Optional<Administrators> adminAux = adminRepository.getAdminId(administrators.getIdAdmin());
            if (adminAux.isEmpty()) {
                return adminRepository.saveAdministrators(administrators);

            } else {
                return administrators;
            }
        }
    }
}