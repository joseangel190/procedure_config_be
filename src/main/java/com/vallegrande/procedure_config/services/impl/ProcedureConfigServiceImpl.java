package com.vallegrande.procedure_config.services.impl;

import com.vallegrande.procedure_config.feignclients.InstituteFeignClient;
import com.vallegrande.procedure_config.feignclients.PhaseFeignClient;
import com.vallegrande.procedure_config.feignclients.ProcedureTypeFeignClient;
import com.vallegrande.procedure_config.model.Institute;
import com.vallegrande.procedure_config.model.Phase;
import com.vallegrande.procedure_config.model.ProcedureConfig;
import com.vallegrande.procedure_config.model.ProcedureType;
import com.vallegrande.procedure_config.repository.ProcedureConfigRepository;
import com.vallegrande.procedure_config.services.ProcedureConfigService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Service
@Slf4j
public class ProcedureConfigServiceImpl implements ProcedureConfigService {

    @Autowired
    private ProcedureConfigRepository procedureConfigRepository;

    // TRANSACCION

    @Autowired
    private ProcedureTypeFeignClient procedureTypeFeignClient;

    @Autowired
    private InstituteFeignClient instituteFeignClient;

    @Autowired
    private PhaseFeignClient phaseFeignClient;

    @Override
    public Flux<ProcedureConfig> listAll() {
        Flux<ProcedureConfig> list = procedureConfigRepository.findAll().publishOn(Schedulers.boundedElastic());
        log.info("Procedure Config listAll: " + list);
        return findProcedureConfigTransacction(list);
    }

    @Override
    public Flux<ProcedureConfig> listByStatus(Boolean active) {
        log.info("Procedure Config listByStatus");
        return procedureConfigRepository.listByStatus(active);
    }

    @Override
    public Mono<ProcedureConfig> create(ProcedureConfig procedureConfig) {
        procedureConfig.setActive(true);
        log.info("Create Procedure Config");
        return procedureConfigRepository.save(procedureConfig);
    }

    @Override
    public Mono<ProcedureConfig> update(ProcedureConfig procedureConfig) {
        log.info("Update Procedure Config");
        return procedureConfigRepository.findById((procedureConfig.getId())).map(pro -> {
            pro.setId(procedureConfig.getId());
            pro.setProcedure_type_id(procedureConfig.getProcedure_type_id());
            pro.setInstitute_id(procedureConfig.getInstitute_id());
            pro.setPhase_id(procedureConfig.getPhase_id());
            pro.getActive();
            return pro;
        }).flatMap(pro -> procedureConfigRepository.save(pro));
    }

    @Override
    public Mono<ProcedureConfig> delete(Integer id) {
        ProcedureConfig prodata = new ProcedureConfig();
        log.info("Delete Procedure Config");
        return procedureConfigRepository.findById((id)).map((procedure) -> {
            prodata.setId(procedure.getId());
            prodata.setProcedure_type_id(procedure.getProcedure_type_id());
            prodata.setInstitute_id(procedure.getInstitute_id());
            prodata.setPhase_id(procedure.getPhase_id());
            prodata.setActive(false);
            return procedure;
        }).flatMap(proc -> procedureConfigRepository.save(prodata));
    }

    @Override
    public Mono<ProcedureConfig> restore(Integer id) {
        ProcedureConfig prodata = new ProcedureConfig();
        log.info("Restore Procedure Config");
        return procedureConfigRepository.findById((id)).map((procedure) -> {
            prodata.setId(procedure.getId());
            prodata.setProcedure_type_id(procedure.getProcedure_type_id());
            prodata.setInstitute_id(procedure.getInstitute_id());
            prodata.setPhase_id(procedure.getPhase_id());
            prodata.setActive(true);
            return procedure;
        }).flatMap(proc -> procedureConfigRepository.save(prodata));

    }

    // DATA

    public Mono<ProcedureConfig> dataProcedureConfig(ProcedureConfig prodata, Integer id) {
        return procedureConfigRepository.findById((id)).map((procedure) -> {
            prodata.setId(procedure.getId());
            prodata.setProcedure_type_id(procedure.getProcedure_type_id());
            prodata.setInstitute_id(procedure.getInstitute_id());
            prodata.setPhase_id(procedure.getPhase_id());
            prodata.getActive();
            return prodata;
        }).flatMap(proc -> procedureConfigRepository.save(prodata));
    }




    // TRASNSACCION

    public Flux<ProcedureConfig> findProcedureConfigTransacction(Flux<ProcedureConfig> list) {
        return list.concatMap(Flux::just).publishOn(Schedulers.boundedElastic()).map(dataProcedureConfig -> {
            Mono<ProcedureType> procedure = procedureTypeFeignClient.listByIdProcedureType(dataProcedureConfig.getProcedure_type_id());
            procedure.subscribe(getProcedure -> dataProcedureConfig.setProcedureType_name(getProcedure.getName()));
            Mono<Institute> institute = instituteFeignClient.listByIdInsitute(dataProcedureConfig.getInstitute_id());
            institute.subscribe(getInstitute -> dataProcedureConfig.setInstitute_name(getInstitute.getName()));
            Mono<Phase> phase = phaseFeignClient.listByIdPhase(dataProcedureConfig.getPhase_id());
            phase.subscribe(getPhase -> dataProcedureConfig.setPhase_name(getPhase.getName()));
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            log.info("Transaction Procedure Config + Procedure Type + Institute + Phase");
            return dataProcedureConfig;
        });

    }


}
