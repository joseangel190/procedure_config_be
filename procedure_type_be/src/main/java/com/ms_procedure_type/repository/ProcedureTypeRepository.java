package com.ms_procedure_type.repository;

import com.ms_procedure_type.model.ProcedureType;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ProcedureTypeRepository extends ReactiveCrudRepository<ProcedureType, Integer> {

    @Query("SELECT * FROM procedure_type WHERE active = :active ORDER BY id DESC")
    Flux<ProcedureType> listByStatus(@Param("active") Boolean active);


}
