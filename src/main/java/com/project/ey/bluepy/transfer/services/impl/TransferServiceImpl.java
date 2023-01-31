package com.project.ey.bluepy.transfer.services.impl;

import com.project.ey.bluepy.transfer.entities.Account;
import com.project.ey.bluepy.transfer.entities.Transfer;
import com.project.ey.bluepy.transfer.repositories.TransferRepository;
import com.project.ey.bluepy.transfer.services.AccountService;
import com.project.ey.bluepy.transfer.services.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TransferServiceImpl implements TransferService {

    @Autowired
    TransferRepository transferRepository;

    @Autowired
    AccountService accountService;

    @Override
    public Transfer doTransfer(Long accountReceiverNumber, Long accountSenderNumber, Float amount) {

        Optional<Account> accountReceiverOpt = accountService.getAccountByNumber(accountReceiverNumber);
        Optional<Account> accountSenderOpt = accountService.getAccountByNumber(accountSenderNumber);

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

    @Override
    public List<Transfer> findAllTransfer() {
        return transferRepository.findAll();
    }
}
