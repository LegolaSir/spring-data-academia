package com.dio.academia.springdataacademia.controller;

import com.dio.academia.springdataacademia.entity.Aluno;
import com.dio.academia.springdataacademia.entity.form.AlunoForm;
import com.dio.academia.springdataacademia.exception.AlunoNotFoundInDBException;
import com.dio.academia.springdataacademia.service.impl.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService service;

    @PostMapping("/create")
    public ResponseEntity create(@Valid @RequestBody AlunoForm form){
        StringBuilder message = new StringBuilder();

        try{
            service.insert(form);

            message.append("ITEM: ")
                    .append(form.getNome())
                    .append(" INSERTED INTO DATABASE");

        } catch (Exception e){
            message.append("FAILED TO CREATE 'ALUNO' REGISTRY [")
                    .append(form.getNome())
                    .append("] INTO DATABASE");
        }

        return ResponseEntity.ok().body(message);
    }

    @GetMapping("/list")
    public List<Aluno> listDB(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity getRegistry(@PathVariable Long id){
        StringBuilder message = new StringBuilder();

        try
        {
            return ResponseEntity.ok().body(service.getById(id));
        }
        catch (AlunoNotFoundInDBException e)
        {
            message.append("ID: [")
                    .append(id)
                    .append("] NOT FOUND IN DATABASE tb_alunos");

            return ResponseEntity.badRequest().body(message);
        }
    }
}
