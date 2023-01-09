package com.project.ey.bluepy.controllers;

import com.project.ey.bluepy.dtos.TransferDto;
import com.project.ey.bluepy.entities.Transfer;
import com.project.ey.bluepy.services.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.rmi.ServerException;

@RestController
public class TransferController {

    @Autowired
    TransferService transferService;

    @PostMapping(path = "transfer",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Transfer> saveTransfer(@RequestBody TransferDto transferDto) throws ServerException {

        Transfer transfer = transferService.doTransfer(transferDto.getAccountRecivierNumber(), transferDto.getAccountSenderNumber(), transferDto.getAmount());

        if (transfer == null) {
            throw new ServerException("Error de datos");
        } else {
            return new ResponseEntity<>(transfer, HttpStatus.CREATED);
        }
    }
}
