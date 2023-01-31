package com.project.ey.bluepy.transfer.services;

import com.project.ey.bluepy.transfer.entities.Transfer;

import java.util.List;

public interface TransferService {
    Transfer doTransfer(Long accountReceiverNumber ,Long accountSenderNumber, Float amount);

    List<Transfer> findAllTransfer();
}
