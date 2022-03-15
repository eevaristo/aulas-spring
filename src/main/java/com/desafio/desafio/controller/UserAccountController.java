package com.desafio.desafio.controller;

import java.util.List;

import com.desafio.desafio.entity.UserAccount;
import com.desafio.desafio.services.UserAccountService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/user/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id){
        if(userAccountService.exitsUserAccountById(id)){
            return ResponseEntity.status(HttpStatus.OK).body(userAccountService.findById(id));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado");
    }

    @PostMapping("/user")
    public ResponseEntity<Object> createUser(@RequestBody UserAccount userAccount){
        if(userAccountService.existsUserAccountByEmail(userAccount.getEmail())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Email já cadastrado");
        };
        return ResponseEntity.status(HttpStatus.OK).body(userAccountService.createUser(userAccount));

    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable Long id){
        Boolean existsById = userAccountService.exitsUserAccountById(id);
        if(existsById){
            userAccountService.deleteUser(id);
            return ResponseEntity.status(HttpStatus.OK).body("Usuário deletado com sucesso");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado!");
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<Object> updateUser(@PathVariable Long id, @RequestBody UserAccount userAccount){
      Boolean existsById = userAccountService.exitsUserAccountById(id);
      if(existsById){
          return ResponseEntity.status(HttpStatus.OK).body(userAccountService.updateUser(id, userAccount));
      }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado!");
    }


    
}
