package com.dio.academia.springdataacademia.entity.form;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlunoForm {
    @NotEmpty(message = "Column [nome] may not be empty")
    @Size(min = 3, max = 80,
            message = "Value: [${validatedValue}] - length may be between {min} and {max}")
    private String nome;

    @NotEmpty(message = "Column [cpf] may not be empty")
//    @CPF
    private String cpf;

    @NotEmpty(message = "Column [bairro] may not be empty")
    private String bairro;

    @NotNull(message = "Column [data_de_nascimento] may not be empty")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataDeNascimento;
}
