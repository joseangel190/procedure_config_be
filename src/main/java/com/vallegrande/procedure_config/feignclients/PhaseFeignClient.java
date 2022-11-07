package com.vallegrande.procedure_config.feignclients;

import com.vallegrande.procedure_config.model.Institute;
import com.vallegrande.procedure_config.model.Phase;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import reactivefeign.spring.config.ReactiveFeignClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@ReactiveFeignClient(name = "phase", url = "http://localhost:8082/v1/phase", configuration = FeignConfig.class)
public interface PhaseFeignClient {

    @GetMapping
    Flux<Phase> listAllPhase();

    @GetMapping("/{phase_id}")
    Mono<Phase> listByIdPhase(@PathVariable Integer phase_id);
}
