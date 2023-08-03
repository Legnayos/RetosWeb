package com.retos.segundociclo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retos.segundociclo.Entities.User;
import com.retos.segundociclo.Repository.UserRepository;



@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAll() {
        return (List<User>) userRepository.getAll();
    }

    public User addUser(User user) {
        return userRepository.addUser(user);
    }

    public Boolean getValidateEmail(String email) {
        return userRepository.getValidateEmail(email);
    }

    public User getLogin(String email, String password) {
        return userRepository.getLogin(email, password);
    }

    public User updUser(User user){
        boolean bGrabar = true;

        if(user.getId() == null || user.getId() == 0)
            bGrabar = false;

        if(bGrabar == true)
            return userRepository.updUser(user);
        else
            return user;
    }
    
    public void delUser(Long id){
        userRepository.delUser(id);
    }
}
