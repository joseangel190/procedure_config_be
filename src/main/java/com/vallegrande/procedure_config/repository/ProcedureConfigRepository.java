package com.vallegrande.procedure_config.repository;

import com.vallegrande.procedure_config.model.ProcedureConfig;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ProcedureConfigRepository extends ReactiveCrudRepository<ProcedureConfig, Integer> {

    @Query("SELECT * FROM procedure_config WHERE active = :active ORDER BY id DESC")
    Flux<ProcedureConfig> listByStatus(@Param("active") Boolean active);



}
