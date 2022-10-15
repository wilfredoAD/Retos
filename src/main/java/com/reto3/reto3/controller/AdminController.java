package com.reto3.reto3.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.reto3.reto3.model.Administrators;
import com.reto3.reto3.service.AdminService;

@RestController
@RequestMapping("/api/Administrators")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.DELETE,RequestMethod.POST,RequestMethod.PUT})

public class AdminController {
@Autowired
public AdminService adminService;

@GetMapping("/all")
public List<Administrators> getAdminFull() {
    return adminService.getAdminFull();
}

@GetMapping("/{Id}")
public Optional<Administrators> getAdminId(@PathVariable("id") int idAdmin) {
    return adminService.getAdminId(idAdmin);
}


@PostMapping("/save")
@ResponseStatus(HttpStatus.CREATED)
public Administrators saveAdministrators(Administrators administrators) {
        return adminService.saveAdministrators(administrators);
    } 

@PutMapping("/update")
@ResponseStatus(HttpStatus.CREATED)
public Administrators updateFull(@RequestBody Administrators administrators){
    return adminService.updateFull(administrators);   

}

@DeleteMapping("/{id}")
@ResponseStatus(HttpStatus.NO_CONTENT)
public boolean deleteAdmin (@PathVariable("id")int id){
    return adminService.deleteAdmin(id);
}

}
