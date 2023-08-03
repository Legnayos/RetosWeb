package com.retos.segundociclo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retos.segundociclo.Entities.Gadget;
import com.retos.segundociclo.Repository.GadgetRepository;

@Service
public class GadgetService {
    
    @Autowired
    private GadgetRepository gadgetRepository;

    public List<Gadget> getAll() {
        return (List<Gadget>) gadgetRepository.getAll();
    }

    public Gadget addGadget(Gadget gadget) {
        return gadgetRepository.addGadget(gadget);
    }

    public Gadget updGadget(Gadget gadget){
        boolean bGrabar = true;

        if(gadget.getId() == null || gadget.getId() == 0)
            bGrabar = false;

        if(bGrabar == true)
            return gadgetRepository.updGadget(gadget);
        else
            return gadget;
    }

    public void delGadget(Long id){
        gadgetRepository.delGadget(id);
    }
}



    

    

 

    
    
    
