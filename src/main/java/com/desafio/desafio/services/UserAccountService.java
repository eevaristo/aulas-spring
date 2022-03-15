package com.desafio.desafio.services;

import com.desafio.desafio.entity.UserAccount;
import com.desafio.desafio.repository.UserAccountRepository;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAccountService {

  @Autowired
  private UserAccountRepository userAccountRepository;

  public List<UserAccount> findAll() {
    List<UserAccount> user = userAccountRepository.findAll();
    return user;
  }

  public UserAccount createUser(UserAccount userAccount) {
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
}
