package com.ms_procedure_type.controller;

import com.ms_procedure_type.model.ProcedureType;
import com.ms_procedure_type.services.ProcedureTypeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1/procedure_type")
@CrossOrigin("http://localhost:4200/")
public class ProcedureTypeController {

    @Autowired
    private ProcedureTypeServices procedureTypeServices;

    @GetMapping
    Flux<ProcedureType> listAll(){
        return procedureTypeServices.ListAllProcedureType();
    }

    @GetMapping("/active/{active}")
    Flux<ProcedureType> listByStatus(@PathVariable Boolean active){
        return procedureTypeServices.listByStatus(active);
    }

    @GetMapping("/{id}")
    Mono<ProcedureType> listById(@PathVariable Integer id){
        return procedureTypeServices.listByIdProcedureType(id);
    }

    @PostMapping
    Mono<ProcedureType> create(@RequestBody ProcedureType procedureType){
        return procedureTypeServices.createProcedureType(procedureType);
    }

    @PutMapping
    Mono<ProcedureType> update(@RequestBody ProcedureType procedureType){
        return procedureTypeServices.updateProcedureType(procedureType);
    }

    @DeleteMapping("/restore/{id}")
    Mono<ProcedureType> restore(@PathVariable Integer id){
        return procedureTypeServices.restoreProcedureType(id);
    }

    @DeleteMapping("/delete/{id}")
    Mono<ProcedureType> delete(@PathVariable Integer id){
        return procedureTypeServices.deleteProcedureType(id);
    }

    @DeleteMapping("/final/{id}")
    Mono<Void> finali(@PathVariable Integer id){
        return procedureTypeServices.deleteFinalProcedureType(id);
    }
}
