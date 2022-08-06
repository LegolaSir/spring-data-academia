package com.dio.academia.springdataacademia.service.impl;

import com.dio.academia.springdataacademia.entity.Exame;
import com.dio.academia.springdataacademia.entity.form.ExameForm;
import com.dio.academia.springdataacademia.repository.AlunoRepository;
import com.dio.academia.springdataacademia.repository.ExameRepository;
import com.dio.academia.springdataacademia.service.IExameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExameService implements IExameService {

    @Autowired
    private ExameRepository exameRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Override
    public void insert(ExameForm form) {
        Exame item = new Exame();

        item.setAluno(
                alunoRepository.findById(form.getIdAluno()).get()
        );
        item.setPeso(form.getPeso());
        item.setAltura(form.getAltura());

        exameRepository.save(item);
    }

    @Override
    public List<Exame> getAll() {
        return exameRepository.findAll();
    }

    @Override
    public List<Exame> getByAlunoId(Long id) {
        return exameRepository.findByAluno(id);
    }
}
