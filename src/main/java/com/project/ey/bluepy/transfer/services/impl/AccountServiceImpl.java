package com.project.ey.bluepy.transfer.services.impl;

import com.project.ey.bluepy.transfer.entities.Account;
import com.project.ey.bluepy.transfer.repositories.AccountRepository;
import com.project.ey.bluepy.transfer.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Override
    public Optional<Account> findAccountById(UUID id) {
        return accountRepository.findById(id);
    }

    @Override
    public Boolean AccountExistById(UUID id) {
        return accountRepository.existsById(id);
    }

    @Override
    public Account saveAccount(Account account) { return accountRepository.save(account);}

    @Override
    public Optional<Account> getAccountByNumber(Long accountNumber) {
        return accountRepository.findAccountByAccountNumber(accountNumber);
    }
}
