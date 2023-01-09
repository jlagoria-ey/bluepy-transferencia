package com.project.ey.bluepy.services;

import com.project.ey.bluepy.entities.Account;
import com.project.ey.bluepy.entities.User;

import java.util.Optional;

public interface AccountService {
    Optional<Account> findAccountById(Long id);
    Boolean AccountExistById(Long id);

    Account saveAccount(Account account);
}
