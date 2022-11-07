package com.vallegrande.procedure_config.services;

import com.vallegrande.procedure_config.model.ProcedureConfig;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProcedureConfigService {

    Flux<ProcedureConfig> listAll();

    Flux<ProcedureConfig> listByStatus(Boolean active);

    Mono<ProcedureConfig> create(ProcedureConfig procedureConfig);

    Mono<ProcedureConfig> update(ProcedureConfig procedureConfig);

    Mono<ProcedureConfig> delete(Integer id);

    Mono<ProcedureConfig> restore(Integer id);


//    TRANSACCION
//
//    Flux<ProcedureType> listAllProcedureType();
//
//    Flux<Institute> listAllInstitute();
//
//    Flux<Phase> listAllPhase();

}
