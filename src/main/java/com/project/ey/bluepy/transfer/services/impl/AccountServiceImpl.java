package com.project.ey.bluepy.transfer.services.impl;

import com.project.ey.bluepy.transfer.entities.Account;
import com.project.ey.bluepy.transfer.repositories.AccountRepository;
import com.project.ey.bluepy.transfer.services.AccountService;
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
