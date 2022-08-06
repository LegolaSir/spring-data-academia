package com.dio.academia.springdataacademia.service.impl;

import com.dio.academia.springdataacademia.entity.Aluno;
import com.dio.academia.springdataacademia.entity.form.AlunoForm;
import com.dio.academia.springdataacademia.repository.AlunoRepository;
import com.dio.academia.springdataacademia.service.IAlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
public class AlunoService implements IAlunoService {

    @Autowired
    private AlunoRepository repository;

    @Override
    public void insert(AlunoForm form) {
        Aluno item = new Aluno();

        item.setNome(form.getNome());
        item.setCpf(form.getCpf());
        item.setBairro(form.getBairro());
        item.setDataDeNascimento(form.getDataDeNascimento());

        repository.save(item);
    }

    @Override
    public List<Aluno> getAll() {
        return repository.findAll();
    }

    @Override
    public Aluno getById(Long id) {
        return repository.findById(id).get();
    }
}
