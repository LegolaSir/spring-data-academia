package com.dio.academia.springdataacademia.repository;

import com.dio.academia.springdataacademia.entity.Exame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExameRepository extends JpaRepository<Exame, Long> {

    @Query("SELECT e FROM Exame e WHERE aluno.id = :id")
    List<Exame> findByAluno(@Param("id") Long id);
}
