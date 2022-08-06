package com.dio.academia.springdataacademia.repository;

import com.dio.academia.springdataacademia.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

}
