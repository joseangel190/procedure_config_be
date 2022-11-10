package com.ms_procedure_type.services.impl;

import com.ms_procedure_type.model.ProcedureType;
import com.ms_procedure_type.repository.ProcedureTypeRepository;
import com.ms_procedure_type.services.ProcedureTypeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProcedureTypeServiceImpl implements ProcedureTypeServices {

    @Autowired
    private ProcedureTypeRepository procedureTypeRepository;

    @Override
    public Flux<ProcedureType> ListAllProcedureType() {
        return procedureTypeRepository.findAll();
    }

    @Override
    public Flux<ProcedureType> listByStatus(Boolean active) {
        return procedureTypeRepository.listByStatus(active);
    }

    @Override
    public Mono<ProcedureType> listByIdProcedureType(Integer id) {
        return procedureTypeRepository.findById(id);
    }

    @Override
    public Mono<ProcedureType> createProcedureType(ProcedureType procedureType) {
        procedureType.setActive(true);
        return procedureTypeRepository.save(procedureType);
    }

    @Override
    public Mono<ProcedureType> updateProcedureType(ProcedureType procedureType) {
        return procedureTypeRepository.findById((procedureType.getId())).map(pro -> {
            pro.setId(procedureType.getId());
            pro.setName(procedureType.getName());
            pro.setPerson_level(procedureType.getPerson_level());
            pro.setAbreviaton(procedureType.getAbreviaton());
            pro.setActive(procedureType.getActive());
            return pro;
        }).flatMap(pro -> procedureTypeRepository.save(pro));

    }

    @Override
    public Mono<ProcedureType> deleteProcedureType(Integer id) {
        ProcedureType prodata = new ProcedureType();
        return procedureTypeRepository.findById((id)).map((procedure) -> {
            prodata.setId(procedure.getId());
            prodata.setName(procedure.getName());
            prodata.setPerson_level(procedure.getPerson_level());
            prodata.setAbreviaton(procedure.getAbreviaton());
            prodata.setActive(false);
            return procedure;
        }).flatMap(career -> procedureTypeRepository.save(prodata));

    }

    @Override
    public Mono<ProcedureType> restoreProcedureType(Integer id) {
        ProcedureType prodata = new ProcedureType();
        return procedureTypeRepository.findById((id)).map((procedure) -> {
            prodata.setId(procedure.getId());
            prodata.setName(procedure.getName());
            prodata.setPerson_level(procedure.getPerson_level());
            prodata.setAbreviaton(procedure.getAbreviaton());
            prodata.setActive(true);
            return procedure;
        }).flatMap(career -> procedureTypeRepository.save(prodata));
    }

    @Override
    public Mono<Void> deleteFinalProcedureType(Integer id) {
        return procedureTypeRepository.deleteById(id);
    }


    // DATOS DEL PROCEDIMIENTO

    public Mono<ProcedureType> dataProcedure(ProcedureType prodata, Integer id) {
        return procedureTypeRepository.findById((id)).map((procedure) -> {
            prodata.setId(procedure.getId());
            prodata.setName(procedure.getName());
            prodata.setPerson_level(procedure.getPerson_level());
            prodata.setAbreviaton(procedure.getAbreviaton());
            prodata.getActive();
            return prodata;
        }).flatMap(career -> procedureTypeRepository.save(prodata));
    }


}
