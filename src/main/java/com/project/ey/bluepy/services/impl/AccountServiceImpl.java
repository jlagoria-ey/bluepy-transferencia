package com.project.ey.bluepy.services.impl;

import com.project.ey.bluepy.entities.Account;
import com.project.ey.bluepy.repositories.AccountRepository;
import com.project.ey.bluepy.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Override
    public Optional<Account> findAccountById(Long id) {
        return accountRepository.findById(id);
    }

    @Override
    public Boolean AccountExistById(Long id) {
        return accountRepository.existsById(id);
    }

    @Override
    public Account saveAccount(Account account) { return accountRepository.save(account);}
}
