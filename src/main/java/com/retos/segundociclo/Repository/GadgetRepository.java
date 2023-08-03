package com.retos.segundociclo.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.retos.segundociclo.CrudRepository.GadgetCrudRepository;
import com.retos.segundociclo.Entities.Gadget;

@Repository
public class GadgetRepository {
    
    @Autowired
    private GadgetCrudRepository gadgetCrudRepository;

    public List<Gadget> getAll() {
        return (List<Gadget>) gadgetCrudRepository.findAll();
    }

    public Gadget addGadget(Gadget gadget) {
        return gadgetCrudRepository.save(gadget);
    }

    public Gadget existGadget(Long Id){

        Optional <Gadget> objGadget = gadgetCrudRepository.findById(Id);
        Gadget objGadgetRespuesta;

        if(objGadget.isEmpty() == true)
            objGadgetRespuesta = null;

        else{
            objGadgetRespuesta = objGadget.get();
        }
        
        return objGadgetRespuesta;
    }

    public Gadget updGadget(Gadget gadget){

        Gadget objGadget = existGadget(gadget.getId());

        if(objGadget == null)
        {
            return gadget;
        } 

        if(gadget.getBrand() !=  null)
            objGadget.setBrand(gadget.getBrand());

        if(gadget.getCategory() !=  null)
            objGadget.setCategory(gadget.getCategory());

        if(gadget.getName() !=  null)
            objGadget.setName(gadget.getName());

        if(gadget.getDescription() !=  null)
            objGadget.setDescription(gadget.getDescription());

        if(gadget.getPrice() !=  null)
            objGadget.setPrice(gadget.getPrice());

        if(gadget.getAvailability() !=  null)
            objGadget.setAvailability(gadget.getAvailability());

        if(gadget.getQuantity() !=  null)
            objGadget.setQuantity(gadget.getQuantity());

        if(gadget.getPhotography() !=  null)
            objGadget.setPhotography(gadget.getPhotography());

        return gadgetCrudRepository.save(objGadget);
    }

    public void delGadget(Long id){
        Gadget objGadget = existGadget(id);
        if(objGadget != null){
            gadgetCrudRepository.deleteById(id);
        }
    }
}
    

    

    

    
