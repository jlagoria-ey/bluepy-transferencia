package com.project.ey.bluepy.transfer.batch.item.writer;

import com.project.ey.bluepy.transfer.csv.CSVProcessor;
import com.project.ey.bluepy.transfer.entities.Transfer;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TransferWriter implements ItemWriter<Transfer> {

    @Autowired
    CSVProcessor csvProcessor;

    @Override
    public void write(List<? extends Transfer> list) throws Exception {
        csvProcessor.createCSVFile(list);
    }
}
