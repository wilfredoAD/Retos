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

import com.reto3.reto3.model.Partyroom;
import com.reto3.reto3.service.PartyroomService;

@RestController
@RequestMapping("/api/Partyroom")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.DELETE, RequestMethod.POST,
        RequestMethod.PUT })
public class PartyroomController {

    @Autowired
    private PartyroomService partyroomService;

    @GetMapping("/all")
    public List<Partyroom> getPartyroomsFull() {
        return partyroomService.getPartyroomsFull();
    }

    @GetMapping("/{id}")
    public Optional<Partyroom> getPartyroomId(@PathVariable("id") int id) {
        return partyroomService.getPartyroomId(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Partyroom savePartyroom(@RequestBody Partyroom partyroom) {
        return partyroomService.savePartyroom(partyroom);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Partyroom updateFull(@RequestBody Partyroom partyroom) {
        return partyroomService.updateFull(partyroom);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deletePartyroom(@PathVariable("id") int id) {
        return partyroomService.deletePartyroom(id);
    }
}
