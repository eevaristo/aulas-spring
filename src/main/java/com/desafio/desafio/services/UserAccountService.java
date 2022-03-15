package com.desafio.desafio.services;

import com.desafio.desafio.entity.UserAccount;
import com.desafio.desafio.repository.UserAccountRepository;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserAccountService {

  @Autowired
  private UserAccountRepository userAccountRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  public List<UserAccount> findAll() {
    List<UserAccount> user = userAccountRepository.findAll();
    return user;
  }

  public UserAccount createUser(UserAccount userAccount) {
    userAccount.setPassword(passwordEncoder.encode(userAccount.getPassword()));
    userAccount.setCreatAt(LocalDateTime.now());
    UserAccount user = userAccountRepository.save(userAccount);
    return user;
  }

  public void deleteUser(Long id) {
    UserAccount user = new UserAccount();
    user.setId(id);
    userAccountRepository.delete(user);
  }

  public UserAccount updateUser(Long id,UserAccount userAccount){
    userAccount.setId(id);
    UserAccount user = userAccountRepository.save(userAccount);
    return user;
  }

  public Boolean existsUserAccountByEmail(String email){
    return userAccountRepository.existsUserAccountByEmail(email);
  }

  public Boolean exitsUserAccountById(Long id){
    return userAccountRepository.existsById(id);
  }

  public UserAccount findById(Long id){
    return userAccountRepository.findById(id).get();
  }



}
