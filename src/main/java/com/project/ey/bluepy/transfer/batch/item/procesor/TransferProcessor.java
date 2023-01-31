package com.project.ey.bluepy.transfer.batch.item.procesor;

import com.project.ey.bluepy.transfer.dtos.TransferBatchDTO;
import com.project.ey.bluepy.transfer.entities.Account;
import com.project.ey.bluepy.transfer.entities.Transfer;
import com.project.ey.bluepy.transfer.services.AccountService;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class TransferProcessor implements ItemProcessor<Transfer, Transfer> {

    @Autowired
    AccountService accountService;

    @Override
    public Transfer process(Transfer transfer) throws Exception {
        return transfer;
    }
}
