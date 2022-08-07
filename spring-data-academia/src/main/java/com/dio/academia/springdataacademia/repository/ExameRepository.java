package com.dio.academia.springdataacademia.repository;

import com.dio.academia.springdataacademia.entity.Exame;
import org.hibernate.annotations.SQLUpdate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ExameRepository extends JpaRepository<Exame, Long> {

    @Query("SELECT e FROM Exame e WHERE aluno.id = :id")
    List<Exame> findByAluno(@Param("id") Long id);

    @Transactional
    @Modifying
    @Query("UPDATE Exame e SET e.peso= :peso, e.altura= :altura WHERE e.id= :id")
    void update(@Param("id") Long id,
                @Param("peso") Double peso,
                @Param("altura") Double altura);

    @Transactional
    @Modifying
    @Query("UPDATE Exame e SET e.aluno.id= :idAluno WHERE e.id= :id")
    void updateRelatedAluno(@Param("id") Long id,
                            @Param("idAluno") Long idAluno);
}
