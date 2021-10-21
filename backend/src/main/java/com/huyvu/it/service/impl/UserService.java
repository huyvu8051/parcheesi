package com.huyvu.it.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huyvu.it.models.Player;
import com.huyvu.it.models.Provider;
import com.huyvu.it.repository.PlayerRepository;

@Service
public class UserService {
 
    @Autowired
    private PlayerRepository repo;
     
    public void processOAuthPostLogin(String username) {
        Player existUser = repo.findOneByUsername(username);
         
        if (existUser == null) {
        	Player newUser = new Player();
            newUser.setUsername(username);
            newUser.setProvider(Provider.FACEBOOK);
             
            repo.save(newUser);        
        }
         
    }  
}