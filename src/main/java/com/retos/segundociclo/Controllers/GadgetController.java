package com.retos.segundociclo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.retos.segundociclo.CrudRepository.GadgetCrudRepository;
import com.retos.segundociclo.Entities.Gadget;
import com.retos.segundociclo.Services.GadgetService;

import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/gadget")
@CrossOrigin(origins = "*")
public class GadgetController {
    
    @Autowired
    private GadgetService gadgetService;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Gadget> getAll() {
        return gadgetService.getAll();
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Gadget addGadget(@RequestBody Gadget gadget) {
        return gadgetService.addGadget(gadget);
    }

    @Autowired
    GadgetCrudRepository gadgetRepository;

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Gadget updGadget(@RequestBody Gadget gadget){
        return (Gadget) gadgetService.updGadget(gadget);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delGadget(@PathVariable Long id){
        gadgetService.delGadget(id);
    }
}


    

    
    
    

    
    
    
    
    
    
    
    