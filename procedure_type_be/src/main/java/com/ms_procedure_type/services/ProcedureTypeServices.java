package com.ms_procedure_type.services;

import com.ms_procedure_type.model.ProcedureType;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProcedureTypeServices {

    Flux<ProcedureType> ListAllProcedureType();

    Flux<ProcedureType> listByStatus(Boolean active);

    Mono<ProcedureType> listByIdProcedureType(Integer id);

    Mono<ProcedureType> createProcedureType(ProcedureType procedureType);

    Mono<ProcedureType> updateProcedureType(ProcedureType procedureType);

    Mono<ProcedureType> deleteProcedureType(Integer id);

    Mono<ProcedureType> restoreProcedureType(Integer id);

    Mono<Void> deleteFinalProcedureType(Integer id);
}
