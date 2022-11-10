package com.vallegrande.institute.services.impl;

import com.vallegrande.institute.model.Institute;
import com.vallegrande.institute.repository.InstituteRepository;
import com.vallegrande.institute.services.InstituteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class InstituteServiceImpl implements InstituteService {

    @Autowired
    private InstituteRepository instituteRepository;

    @Override
    public Flux<Institute> listAll() {
        return instituteRepository.findAll();
    }

    @Override
    public Mono<Institute> create(Institute institute) {
        institute.setActive(true);
        return instituteRepository.save(institute);
    }

    @Override
    public Mono<Institute> listByIdInstitute(Integer id) {
        return instituteRepository.findById(id);
    }
}
