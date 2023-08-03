package com.retos.segundociclo.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.retos.segundociclo.CrudRepository.UserCrudRepository;
import com.retos.segundociclo.Entities.User;



@Repository
public class UserRepository {
    @Autowired
    private UserCrudRepository userCrudRepository;

    public List<User> getAll() {
        return (List<User>) userCrudRepository.findAll();
    }

    public User addUser(User user) {
        return userCrudRepository.save(user);
    }

    public boolean getValidateEmail(String email) {
        Optional<User> miUsuario = userCrudRepository.findbyEmail(email);

        if (miUsuario.isEmpty())
            return false;
        else
            return true;
    }
    
    public User getLogin(String email, String password) {
        Optional<User> miUsuario = userCrudRepository.findbyEmailandPassword(email, password);
        User usuarioRespuesta = new User();

        if (miUsuario.isEmpty()) {
            /* 
            usuarioRespuesta.setEmail(email);
            usuarioRespuesta.setPassword(password);
            usuarioRespuesta.setName("NO DEFINIDO");
            */
            usuarioRespuesta.setId(null);
         } 
         else {
             usuarioRespuesta = miUsuario.get();
         }
         return usuarioRespuesta;
    }

    public User existUser(Long Id){

        Optional <User> objUser = userCrudRepository.findById(Id);
        User objUserRespuesta;

        if(objUser.isEmpty() == true)
            objUserRespuesta = null;

        else{
            objUserRespuesta = objUser.get();
        }
        
        return objUserRespuesta;
    }

    public User updUser(User user){

        User objUser = existUser(user.getId());

        if(objUser == null)
        {
            return user;
        } 

        if(user.getIdentification() !=  null)
            objUser.setIdentification(user.getIdentification());

        if(user.getName() !=  null)
            objUser.setName(user.getName());

        if(user.getAddress() !=  null)
            objUser.setAddress(user.getAddress());

        if(user.getCellPhone() !=  null)
            objUser.setCellPhone(user.getCellPhone());

        if(user.getEmail() !=  null)
            objUser.setEmail(user.getEmail());

        if(user.getPassword() !=  null)
            objUser.setPassword(user.getPassword());

        if(user.getZone() !=  null)
            objUser.setZone(user.getZone());

        if(user.getType() !=  null)
            objUser.setType(user.getType());

        return userCrudRepository.save(objUser);
    }

    public void delUser(Long id){
        User objUser = existUser(id);
        if(objUser != null){
            userCrudRepository.deleteById(id);
        }
    }
}
