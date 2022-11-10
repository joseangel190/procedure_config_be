package com.vallegrande.phase.services;

import com.vallegrande.phase.model.Phase;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PhaseService {

    Flux<Phase> listAll();

    Mono<Phase> lisByIdPhase(Integer id);

    Mono<Phase> create(Phase phase);

}
