package com.project.ey.bluepy.services;

import com.project.ey.bluepy.entities.Transfer;

public interface TransferService {
    Transfer doTransfer(Long accountReceiverNumber ,Long accountSenderNumber, Float amount);
}
