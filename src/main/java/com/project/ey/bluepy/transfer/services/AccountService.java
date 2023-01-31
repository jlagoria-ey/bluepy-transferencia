package com.project.ey.bluepy.transfer.services;

import com.project.ey.bluepy.transfer.entities.Account;

import java.util.Optional;
import java.util.UUID;

public interface AccountService {
    Optional<Account> findAccountById(UUID id);
    Boolean AccountExistById(UUID id);
    Account saveAccount(Account account);

    Optional<Account> getAccountByNumber(Long accountNumber);
}
