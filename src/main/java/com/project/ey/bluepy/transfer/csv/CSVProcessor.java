package com.project.ey.bluepy.transfer.csv;

import com.project.ey.bluepy.transfer.entities.Transfer;
import com.project.ey.bluepy.transfer.entities.User;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
public class CSVProcessor {

    String[] HEADERS = { "id Transaccion", "Monto","Nombre del receptor", "Nro de cuenta receptor",
        "Nombre del remitente", "Nro Cuenta de origen", "Fecha"};
    public void createCSVFile(List<? extends Transfer> transfers) throws IOException {
        Date date = new Date();
        SimpleDateFormat DateFor = new SimpleDateFormat("yyyy-MM-dd");
        String stringDate = DateFor.format(date);

        FileWriter out = new FileWriter("transfersArchives/transaccion-sistemas-py-"+stringDate+".csv");
        try (CSVPrinter printer = new CSVPrinter(out, CSVFormat.DEFAULT
                .withHeader(HEADERS))) {
            transfers.forEach(transfer -> {
                try {
                    printer.printRecord(transfer.getId(),
                            transfer.getTransferredAmount(),
                            transfer.getAccountReceiver().getUser().getName(),
                            transfer.getAccountReceiver().getAccountNumber(),
                            transfer.getAccountSender().getUser().getName(),
                            transfer.getAccountSender().getAccountNumber(),
                            transfer.getDateTransfer());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }
}
