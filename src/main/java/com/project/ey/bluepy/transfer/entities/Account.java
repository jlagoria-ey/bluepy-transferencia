package com.project.ey.bluepy.transfer.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name="cuenta")
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="id", columnDefinition = "BINARY(16)")
    private UUID id = UUID.randomUUID();

    @Column(name="saldo_cuenta")
    private Float amount;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "users_id")
    private User user;

    @Column(name="activa")
    private Boolean activa;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Boolean getActiva() {
        return activa;
    }

    public void setActiva(Boolean activa) {
        this.activa = activa;
    }
}
