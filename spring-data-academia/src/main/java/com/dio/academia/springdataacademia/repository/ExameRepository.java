package com.dio.academia.springdataacademia.repository;

import com.dio.academia.springdataacademia.entity.Exame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExameRepository extends JpaRepository<Exame, Long> {
}
