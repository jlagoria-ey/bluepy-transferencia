package com.project.ey.bluepy.transfer.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "persona")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name="id", columnDefinition = "BINARY(16)")
    private UUID id = UUID.randomUUID();

    @Column(name="name")
    private String name;

    @Column(name="last_name")
    private String lastName;

    @Column(name="persona_number")
    private Long personaNumber;

    @Column(name="activa")
    private Boolean activa;

    public User() {
    }

    public User(String name, String lastName, Long personaNumber, Boolean activa) {
        this.name = name;
        this.lastName = lastName;
        this.personaNumber = personaNumber;
        this.activa = activa;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getPersonaNumber() {
        return personaNumber;
    }

    public void setPersonaNumber(Long personaNumber) {
        this.personaNumber = personaNumber;
    }

    public Boolean getActiva() {
        return activa;
    }

    public void setActiva(Boolean activa) {
        this.activa = activa;
    }
}
