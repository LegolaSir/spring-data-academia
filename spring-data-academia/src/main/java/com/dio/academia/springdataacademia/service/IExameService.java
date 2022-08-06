package com.dio.academia.springdataacademia.service;

import com.dio.academia.springdataacademia.entity.Exame;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IExameService {

    void insert(Exame item);

    List<Exame> getAll();

    Exame getById(Long id);
}
