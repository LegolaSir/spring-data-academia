package com.dio.academia.springdataacademia.controller;

import com.dio.academia.springdataacademia.entity.Aluno;
import com.dio.academia.springdataacademia.entity.form.AlunoForm;
import com.dio.academia.springdataacademia.service.impl.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService service;

    @PostMapping("/create")
    public ResponseEntity create(@RequestBody AlunoForm form){
        StringBuilder message = new StringBuilder();

        service.insert(form);

        message.append("ITEM: ")
                .append(form.getNome())
                .append(" INSERTED INTO DATABASE");

        return ResponseEntity.ok().body(message);
    }

    @GetMapping("/list")
    public List<Aluno> listDB(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> getRegistry(@PathVariable Long id){
        return ResponseEntity.ok().body(service.getById(id));
    }
}
