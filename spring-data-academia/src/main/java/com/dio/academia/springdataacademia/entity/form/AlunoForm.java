package com.dio.academia.springdataacademia.entity.form;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlunoForm {
    private String nome;

    private String cpf;

    private String bairro;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataDeNascimento;
}
