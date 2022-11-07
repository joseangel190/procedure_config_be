package com.vallegrande.procedure_config.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;

public class ProcedureConfig {

    @Id private Integer id;
    @Column private Integer procedure_type_id;
    @Column private Integer institute_id;
    @Column private Integer phase_id;
    @Column private Boolean active;

    // TRANSACCION

    @Transient
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String procedureType_name;
    @Transient
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String institute_name;
    @Transient
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String phase_name;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProcedure_type_id() {
        return procedure_type_id;
    }

    public void setProcedure_type_id(Integer procedure_type_id) {
        this.procedure_type_id = procedure_type_id;
    }

    public Integer getInstitute_id() {
        return institute_id;
    }

    public void setInstitute_id(Integer institute_id) {
        this.institute_id = institute_id;
    }

    public Integer getPhase_id() {
        return phase_id;
    }

    public void setPhase_id(Integer phase_id) {
        this.phase_id = phase_id;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getProcedureType_name() {
        return procedureType_name;
    }

    public void setProcedureType_name(String procedureType_name) {
        this.procedureType_name = procedureType_name;
    }

    public String getInstitute_name() {
        return institute_name;
    }

    public void setInstitute_name(String institute_name) {
        this.institute_name = institute_name;
    }

    public String getPhase_name() {
        return phase_name;
    }

    public void setPhase_name(String phase_name) {
        this.phase_name = phase_name;
    }

    public ProcedureConfig() {
    }

    public ProcedureConfig(Integer id, Integer procedure_type_id, Integer institute_id, Integer phase_id, Boolean active, String procedureType_name, String institute_name, String phase_name) {
        this.id = id;
        this.procedure_type_id = procedure_type_id;
        this.institute_id = institute_id;
        this.phase_id = phase_id;
        this.active = active;
        this.procedureType_name = procedureType_name;
        this.institute_name = institute_name;
        this.phase_name = phase_name;
    }
}
