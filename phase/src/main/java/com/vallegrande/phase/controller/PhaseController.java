package com.vallegrande.phase.controller;

import com.vallegrande.phase.model.Phase;
import com.vallegrande.phase.services.PhaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1/phase")
@CrossOrigin("http://localhost:4200/")
public class PhaseController {

    @Autowired
    private PhaseService phaseService;

    @GetMapping
    Flux<Phase> listAll(){
        return phaseService.listAll();
    }

    @GetMapping("{id}")
    Mono<Phase> listById(@PathVariable Integer id){
        return phaseService.lisByIdPhase(id);
    }

    @PostMapping
    Mono<Phase> create(@RequestBody Phase phase){
        return phaseService.create(phase);
    }

}
