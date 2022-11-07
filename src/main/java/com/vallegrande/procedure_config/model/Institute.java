package com.vallegrande.procedure_config.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

public class Institute {

    @Id private Integer id;
    @Column private String name;
    @Column private String academic_area;
    @Column private String career;
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

    public String getAcademic_area() {
        return academic_area;
    }

    public void setAcademic_area(String academic_area) {
        this.academic_area = academic_area;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Institute() {
    }

    public Institute(Integer id, String name, String academic_area, String career, Boolean active) {
        this.id = id;
        this.name = name;
        this.academic_area = academic_area;
        this.career = career;
        this.active = active;
    }
}
