package com.vallegrande.institute.repository;

import com.vallegrande.institute.model.Institute;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstituteRepository extends ReactiveCrudRepository<Institute, Integer> {
}
