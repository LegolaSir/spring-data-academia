package com.dio.academia.springdataacademia.service;

import com.dio.academia.springdataacademia.entity.Aluno;
import com.dio.academia.springdataacademia.entity.form.AlunoForm;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IAlunoService {

    void insert(AlunoForm form);

    List<Aluno> getAll();

    Aluno getById(Long id);
}
