package com.vallegrande.procedure_config.feignclients;

import com.vallegrande.procedure_config.model.ProcedureType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import reactivefeign.spring.config.ReactiveFeignClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@ReactiveFeignClient(name = "procedure-type", url = "http://localhost:8080/v1/procedure_type", configuration = FeignConfig.class)
public interface ProcedureTypeFeignClient {

    @GetMapping
    Flux<ProcedureType> listAllProcedureType();

    @GetMapping("/{procedure_type_id}")
    Mono<ProcedureType> listByIdProcedureType(@PathVariable Integer procedure_type_id);
}
