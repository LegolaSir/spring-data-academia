package com.dio.academia.springdataacademia.service.impl;

import com.dio.academia.springdataacademia.entity.Exame;
import com.dio.academia.springdataacademia.entity.form.ExameForm;
import com.dio.academia.springdataacademia.exception.AlunoNotFoundInDBException;
import com.dio.academia.springdataacademia.exception.ExameNotFoundInDBException;
import com.dio.academia.springdataacademia.exception.NullRequestParameterException;
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
        if(!alunoRepository.findById(id).isPresent()) throw new AlunoNotFoundInDBException();

        return exameRepository.findByAluno(id);
    }

    @Override
    public void update(Long id, Double peso, Double altura) {
        if(!exameRepository.findById(id).isPresent()) throw new ExameNotFoundInDBException();

        if(peso != null && altura == null) altura = exameRepository.findById(id).get().getAltura();
        else if(altura != null && peso == null) peso = exameRepository.findById(id).get().getPeso();
        else if(peso == null && altura == null) throw new NullRequestParameterException();

        exameRepository.update(id, peso, altura);
    }

    @Override
    public void updateRelatedAluno(Long id, Long idAluno) {
        if(!exameRepository.findById(id).isPresent()) throw new ExameNotFoundInDBException();
        if(!alunoRepository.findById(idAluno).isPresent() || idAluno == null) throw new AlunoNotFoundInDBException();

        exameRepository.updateRelatedAluno(id, idAluno);
    }
}
