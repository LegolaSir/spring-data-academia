package com.dio.academia.springdataacademia.controller;

import com.dio.academia.springdataacademia.entity.Exame;
import com.dio.academia.springdataacademia.entity.form.ExameForm;
import com.dio.academia.springdataacademia.exception.AlunoNotFoundInDBException;
import com.dio.academia.springdataacademia.exception.ExameNotFoundInDBException;
import com.dio.academia.springdataacademia.exception.NullRequestParameterException;
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

            return ResponseEntity.ok().body(message);

        } catch(Exception e){
            message.append("FAILED TO CREATE 'EXAME' REGISTRY INTO DATABASE");

            return ResponseEntity.badRequest().body(message);
        }


    }

    @GetMapping("/list")
    public ResponseEntity<List<Exame>> listDB(){
        return ResponseEntity.ok().body(service.getAll());
    }

    @GetMapping("/aluno/{id}")
    public ResponseEntity getRegistryByAlunoId(@PathVariable Long id){

        try {
            return ResponseEntity.ok().body(service.getByAlunoId(id));

        } catch (Exception e){
            StringBuilder message = new StringBuilder();

            message.append("ID: [")
                    .append(id)
                    .append("] NOT FOUND IN DATABASE");

            return ResponseEntity.badRequest().body(message);
        }
    }

    @PostMapping("/update/{id}")
    public ResponseEntity update(@PathVariable Long id,
                                 @RequestParam(value = "peso", required = false) Double peso,
                                 @RequestParam(value = "altura", required = false) Double altura)
    {
        StringBuilder message = new StringBuilder();

        try{
            service.update(id, peso, altura);

            message.append("REGISTRY IDENTIFIED BY ID: [")
                    .append(id)
                    .append("] UPDATED IN DATABASE tb_exames");

            return ResponseEntity.ok().body(message);
        }
        catch (ExameNotFoundInDBException e){
            message.append("FAILED TO UPDATE EXAM_ID: [")
                    .append(id)
                    .append("] - NOT REGISTERED INTO DATABASE tb_exames.");

        }
        catch (NullRequestParameterException e){
            message.append("FAILED TO UPDATE EXAM_ID: [")
                    .append(id)
                    .append("] - ALL PARAMETERS ARE NULL | EMPTY.");

        }

        return ResponseEntity.badRequest().body(message);
    }

    @PostMapping("/update/aluno/{id}")
    public ResponseEntity updateRelatedAluno(@PathVariable Long id,
                                             @RequestParam(value = "idAluno") Long idAluno)
    {
        StringBuilder message = new StringBuilder();

        try
        {
            service.updateRelatedAluno(id, idAluno);

            message.append("REGISTRY IDENTIFIED BY ID: [")
                    .append(id)
                    .append("] UPDATED IN DATABASE tb_exames");

            return ResponseEntity.ok().body(message);
        }
        catch (ExameNotFoundInDBException e)
        {
            message.append("FAILED TO UPDATE EXAM_ID: [")
                    .append(id)
                    .append("] - NOT REGISTERED INTO DATABASE tb_exames.");
        }
        catch(AlunoNotFoundInDBException e)
        {
            message.append("FAILED TO UPDATE EXAM_ID: [")
                    .append(id)
                    .append("] - VALUE ID_ALUNO: [")
                    .append(idAluno)
                    .append("] NOT REGISTERED INTO DATABASE tb_alunos");
        }

        return ResponseEntity.badRequest().body(message);
    }
}
