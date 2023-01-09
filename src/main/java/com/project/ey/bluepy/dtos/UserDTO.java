package com.project.ey.bluepy.dtos;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.UUID;

public class UserDTO {

    private Long id;

    private String name;

    private String lastName;

    private Long id_persona;

    private Boolean activa;

    public UserDTO(Long id, String name, String lastName, Long id_persona, Boolean activa) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.id_persona = id_persona;
        this.activa = activa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Long getId_persona() {
        return id_persona;
    }

    public void setId_persona(Long id_persona) {
        this.id_persona = id_persona;
    }

    public Boolean getActiva() {
        return activa;
    }

    public void setActiva(Boolean activa) {
        this.activa = activa;
    }
}
