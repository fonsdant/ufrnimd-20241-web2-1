package ufrn.imd.crud.controller;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Getter;
import lombok.With;
import org.hibernate.validator.constraints.br.CPF;
import ufrn.imd.crud.domain.Genero;

import java.time.LocalDate;

@Builder
@Getter
@With
final class ProfessorDto {
    private Long id;
    private String nome;
    @CPF
    private String cpf;
    @Positive
    private Integer matricula;
    private Genero genero;
    private String departamento;
    @Past
    private LocalDate dataNascimento;
    @Positive
    private Float salario;
    private String disciplinaAssociada;
}
