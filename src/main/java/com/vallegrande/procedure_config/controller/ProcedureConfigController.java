package com.vallegrande.procedure_config.controller;

import com.vallegrande.procedure_config.model.ProcedureConfig;
import com.vallegrande.procedure_config.services.ProcedureConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1/procedure_config")
@CrossOrigin("http://localhost:4200")
public class ProcedureConfigController {

    @Autowired
    private ProcedureConfigService procedureConfigService;

    @GetMapping
    Flux<ProcedureConfig> listAll(){
        return procedureConfigService.listAll();
    }

    @GetMapping("/active/{active}")
    Flux<ProcedureConfig> listByStatus(@PathVariable Boolean active){
        return procedureConfigService.listByStatus(active);
    }

    @PostMapping
    Mono<ProcedureConfig> create(@RequestBody ProcedureConfig procedureConfig){
        return procedureConfigService.create(procedureConfig);
    }

    @PutMapping()
    Mono<ProcedureConfig> update(@RequestBody ProcedureConfig procedureConfig){
        return procedureConfigService.update(procedureConfig);
    }

    @DeleteMapping("/delete/{id}")
    Mono<ProcedureConfig> delete(@PathVariable Integer id){
        return procedureConfigService.delete(id);
    }

    @DeleteMapping("/restore/{id}")
    Mono<ProcedureConfig> restore(@PathVariable Integer id){
        return procedureConfigService.restore(id);
    }
}
