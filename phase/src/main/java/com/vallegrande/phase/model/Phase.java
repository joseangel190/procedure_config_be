package com.vallegrande.phase.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

public class Phase {

    @Id private Integer id;
    @Column private String name;
    @Column private Boolean notification;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getNotification() {
        return notification;
    }

    public void setNotification(Boolean notification) {
        this.notification = notification;
    }

    public Phase() {
    }

    public Phase(Integer id, String name, Boolean notification) {
        this.id = id;
        this.name = name;
        this.notification = notification;
    }
}
