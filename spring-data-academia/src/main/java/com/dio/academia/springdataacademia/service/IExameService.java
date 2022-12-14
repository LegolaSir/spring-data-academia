package com.dio.academia.springdataacademia.service;

import com.dio.academia.springdataacademia.entity.Exame;
import com.dio.academia.springdataacademia.entity.form.ExameForm;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IExameService {

    void insert(ExameForm form);

    List<Exame> getAll();

    List<Exame> getByAlunoId(Long id);

    void update(Long id, Double peso, Double altura);

    void updateRelatedAluno(Long id, Long idAluno);
}
