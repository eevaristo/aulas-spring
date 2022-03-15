package com.desafio.desafio.repository;

import com.desafio.desafio.entity.UserAccount;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {

    boolean existsUserAccountByEmail(String email);
    
}
