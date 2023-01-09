package com.project.ey.bluepy.entities;

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

    public Transfer(Float transferredAmount, Account accountReceiver, Account accountSender, Date dateTransfer) {
        this.transferredAmount = transferredAmount;
        this.accountReceiver = accountReceiver;
        this.accountSender = accountSender;
        this.dateTransfer = dateTransfer;
    }
}

