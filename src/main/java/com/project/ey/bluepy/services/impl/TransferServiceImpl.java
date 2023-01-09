package com.project.ey.bluepy.services.impl;

import com.project.ey.bluepy.entities.Account;
import com.project.ey.bluepy.entities.Transfer;
import com.project.ey.bluepy.repositories.TransferRepository;
import com.project.ey.bluepy.services.AccountService;
import com.project.ey.bluepy.services.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class TransferServiceImpl implements TransferService {

    @Autowired
    TransferRepository transferRepository;

    @Autowired
    AccountService accountService;

    @Override
    public Transfer doTransfer(Long accountReceiverNumber, Long accountSenderNumber, Float amount) {

        Optional<Account> accountReceiverOpt = accountService.findAccountById(accountReceiverNumber);
        Optional<Account> accountSenderOpt = accountService.findAccountById(accountSenderNumber);

        if(!accountReceiverOpt.isPresent() || !accountSenderOpt.isPresent()){
            return null;
        }

        Account accountReceiver = accountReceiverOpt.get();
        Account accountSender = accountSenderOpt.get();

        if (accountSender.getAmount() >= amount){

            accountSender.setAmount(accountSender.getAmount() - amount);
            accountReceiver.setAmount(accountReceiver.getAmount() + amount);

            accountService.saveAccount(accountReceiver);
            accountService.saveAccount(accountSender);

            Transfer transferToSave = new Transfer(amount,accountReceiver,accountSender, new Date());

             return transferRepository.save(transferToSave);
        }

        return null;
    }
}
