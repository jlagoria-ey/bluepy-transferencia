package com.project.ey.bluepy.transfer.dtos;

import java.util.Date;
import java.util.UUID;

public class TransferBatchDTO extends TransferApiDto{

    private UUID id;
    private String nameRecivier;
    private String NameSender;
    private Date date;

    public TransferBatchDTO() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNameRecivier() {
        return nameRecivier;
    }

    public void setNameRecivier(String nameRecivier) {
        this.nameRecivier = nameRecivier;
    }

    public String getNameSender() {
        return NameSender;
    }

    public void setNameSender(String nameSender) {
        NameSender = nameSender;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
