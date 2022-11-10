package com.ms_procedure_type.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

public class ProcedureType {

    @Id private Integer id;
    @Column private String name;
    @Column private String person_level;
    @Column private String abreviaton;
    @Column private Boolean active;

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

    public String getPerson_level() {
        return person_level;
    }

    public void setPerson_level(String person_level) {
        this.person_level = person_level;
    }

    public String getAbreviaton() {
        return abreviaton;
    }

    public void setAbreviaton(String abreviaton) {
        this.abreviaton = abreviaton;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public ProcedureType() {
    }

    public ProcedureType(Integer id, String name, String person_level, String abreviaton, Boolean active) {
        this.id = id;
        this.name = name;
        this.person_level = person_level;
        this.abreviaton = abreviaton;
        this.active = active;
    }
}
