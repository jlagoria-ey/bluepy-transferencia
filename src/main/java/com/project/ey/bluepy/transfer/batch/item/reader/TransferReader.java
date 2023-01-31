package com.project.ey.bluepy.transfer.batch.item.reader;

import com.project.ey.bluepy.transfer.entities.Transfer;
import com.project.ey.bluepy.transfer.services.TransferService;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Iterator;

public class TransferReader implements ItemReader<Transfer> {

    @Autowired
    TransferService transferService;

    private Iterator<Transfer> iterator;

    public TransferReader() {
    }

    @Override
    public Transfer read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        if (this.iterator == null){
            iterator = transferService.findAllTransfer().iterator();
        }
        if(iterator.hasNext()){
            return iterator.next();
        } else {
            return null;
        }
    }
}
