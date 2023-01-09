package com.project.ey.bluepy.transfer.services;

import com.project.ey.bluepy.transfer.entities.Account;

import java.util.Optional;

public interface AccountService {
    Optional<Account> findAccountById(Long id);
    Boolean AccountExistById(Long id);

    Account saveAccount(Account account);
}
