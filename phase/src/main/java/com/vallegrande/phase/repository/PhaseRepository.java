package com.vallegrande.phase.repository;

import com.vallegrande.phase.model.Phase;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhaseRepository extends ReactiveCrudRepository<Phase, Integer> {
}
