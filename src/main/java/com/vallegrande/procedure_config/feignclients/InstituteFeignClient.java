package com.vallegrande.procedure_config.feignclients;

import com.vallegrande.procedure_config.model.Institute;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import reactivefeign.spring.config.ReactiveFeignClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@ReactiveFeignClient(name = "institute", url = "http://localhost:8081/v1/institute", configuration = FeignConfig.class)
public interface InstituteFeignClient {

    @GetMapping
    Flux<Institute> listAllInstitute();

    @GetMapping("/{institute_id}")
    Mono<Institute> listByIdInsitute(@PathVariable Integer institute_id);
}
