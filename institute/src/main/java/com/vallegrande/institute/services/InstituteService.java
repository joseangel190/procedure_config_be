package com.vallegrande.institute.services;

import com.vallegrande.institute.model.Institute;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface InstituteService {

    Flux<Institute> listAll();

    Mono<Institute> create(Institute institute);

    Mono<Institute> listByIdInstitute(Integer id);

}
