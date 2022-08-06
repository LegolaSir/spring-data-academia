package com.dio.academia.springdataacademia.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_exames")
public class Exame {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_aluno")
    private Aluno aluno;

    @Column(name = "data_da_avaliacao")
    private LocalDateTime data = LocalDateTime.now();

    @Column(name = "peso_atual", nullable = false)
    private double peso;

    @Column(name = "altura_atual", nullable = false)
    private double altura;
}
