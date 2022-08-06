package com.dio.academia.springdataacademia.controller;

import com.dio.academia.springdataacademia.entity.form.AlunoForm;
import com.dio.academia.springdataacademia.service.impl.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService service;

    @PostMapping("/create")
    public ResponseEntity create(@RequestBody AlunoForm form){
        StringBuilder message = new StringBuilder();

        try{
            service.insert(form);

            message.append("ITEM: ")
                    .append(form.getNome())
                    .append(" INSERTED INTO DATABASE");

            return ResponseEntity.ok().body(message);
        }
        catch (Exception e){
            message.append("FAILED TO INSERT ")
                    .append(form.getNome())
                    .append(" INTO DATABASE");

            return ResponseEntity.badRequest().body(message);
        }
    }
}
