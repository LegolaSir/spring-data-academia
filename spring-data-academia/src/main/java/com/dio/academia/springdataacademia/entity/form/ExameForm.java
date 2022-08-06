package com.dio.academia.springdataacademia.entity.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExameForm {

    @NotNull(message = "Column [ID_aluno] may not be empty")
    private Long idAluno;

    @NotNull(message = "Column [peso_atual] may not be empty")
    @Positive
    @Min(value = 20, message = "Value: [${validatedValue}] may not be lower than {value}")
    private double peso;

    @NotNull(message = "Column [altura_atual] may not be empty")
    @Positive
    @Min(value = 1, message = "Value: [${validatedValue}] may not be lower than {value}")
    private double altura;
}
