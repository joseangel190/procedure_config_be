package com.vallegrande.institute.controller;

import com.vallegrande.institute.model.Institute;
import com.vallegrande.institute.services.InstituteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1/institute")
@CrossOrigin("http://localhost:4200/")
public class InsituteController {

    @Autowired
    private InstituteService instituteService;

    @GetMapping
    Flux<Institute> listAll(){
        return instituteService.listAll();
    }

    @GetMapping("/{id}")
    Mono<Institute> listById(@PathVariable Integer id){
        return instituteService.listByIdInstitute(id);
    }
    @PostMapping
    Mono<Institute> create(@RequestBody Institute institute){
        return instituteService.create(institute);
    }
}
