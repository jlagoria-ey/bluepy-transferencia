package com.project.ey.bluepy.transfer.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name="transferencia")
public class Transfer implements Serializable  {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="id", columnDefinition = "BINARY(16)")
    private UUID id = UUID.randomUUID();

    @Column(name="monto")
    private Float transferredAmount;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_cuenta_destino")
    private Account accountReceiver;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_cuenta_origen")
    private Account accountSender;

    @Column(name="fecha_transferencia")
    private Date dateTransfer;

    public Transfer() {
    }

    public Transfer(Float transferredAmount, Account accountReceiver, Account accountSender, Date dateTransfer) {
        this.transferredAmount = transferredAmount;
        this.accountReceiver = accountReceiver;
        this.accountSender = accountSender;
        this.dateTransfer = dateTransfer;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Float getTransferredAmount() {
        return transferredAmount;
    }

    public void setTransferredAmount(Float transferredAmount) {
        this.transferredAmount = transferredAmount;
    }

    public Account getAccountReceiver() {
        return accountReceiver;
    }

    public void setAccountReceiver(Account accountReceiver) {
        this.accountReceiver = accountReceiver;
    }

    public Account getAccountSender() {
        return accountSender;
    }

    public void setAccountSender(Account accountSender) {
        this.accountSender = accountSender;
    }

    public Date getDateTransfer() {
        return dateTransfer;
    }

    public void setDateTransfer(Date dateTransfer) {
        this.dateTransfer = dateTransfer;
    }
}

