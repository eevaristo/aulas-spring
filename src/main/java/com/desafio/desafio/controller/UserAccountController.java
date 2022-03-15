package com.desafio.desafio.controller;

import java.util.List;

import com.desafio.desafio.entity.UserAccount;
import com.desafio.desafio.services.UserAccountService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class UserAccountController {

    @Autowired
    private UserAccountService userAccountService;

    @GetMapping("/user")
    public List<UserAccount> listAll(){
        List<UserAccount> user = userAccountService.findAll();
        return user;
    }

    @PostMapping("/user")
    public UserAccount createUser(@RequestBody UserAccount userAccount){
        UserAccount user = userAccountService.createUser(userAccount);
        return user;

    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable Long id){
        userAccountService.deleteUser(id);
    }

    @PutMapping("/user/{id}")
    public UserAccount updateUser(@PathVariable Long id, @RequestBody UserAccount userAccount){
        UserAccount user = userAccountService.updateUser(id, userAccount);
        return user;
    }


    
}
