package com.project.ey.bluepy.transfer.services;

import com.project.ey.bluepy.transfer.entities.Transfer;

public interface TransferService {
    Transfer doTransfer(Long accountReceiverNumber ,Long accountSenderNumber, Float amount);
}
