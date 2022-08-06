package com.dio.academia.springdataacademia.controller;

import com.dio.academia.springdataacademia.entity.Exame;
import com.dio.academia.springdataacademia.entity.form.ExameForm;
import com.dio.academia.springdataacademia.service.impl.ExameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/exames")
public class ExameController {

    @Autowired
    private ExameService service;

    @PostMapping("/create")
    public ResponseEntity create(@Valid @RequestBody ExameForm form){
        StringBuilder message = new StringBuilder();

        try{
            service.insert(form);

            message.append("EXAM CREATED AND LINKED INTO ALUNO_ID: ")
                    .append(form.getIdAluno())
                    .append(" FROM tb_alunos");

        } catch(Exception e){
            message.append("FAILED TO CREATE EXAM REGISTRY");
        }

        return ResponseEntity.ok().body(message);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Exame>> listDB(){
        return ResponseEntity.ok().body(service.getAll());
    }
}
