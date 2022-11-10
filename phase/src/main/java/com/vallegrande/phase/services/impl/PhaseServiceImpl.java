package com.vallegrande.phase.services.impl;

import com.vallegrande.phase.model.Phase;
import com.vallegrande.phase.repository.PhaseRepository;
import com.vallegrande.phase.services.PhaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PhaseServiceImpl implements PhaseService {

    @Autowired
    private PhaseRepository phaseRepository;

    @Override
    public Flux<Phase> listAll() {
        return phaseRepository.findAll();
    }

    @Override
    public Mono<Phase> lisByIdPhase(Integer id) {
        return phaseRepository.findById(id);
    }

    @Override
    public Mono<Phase> create(Phase phase) {
        phase.setNotification(true);
        return phaseRepository.save(phase);
    }
}
