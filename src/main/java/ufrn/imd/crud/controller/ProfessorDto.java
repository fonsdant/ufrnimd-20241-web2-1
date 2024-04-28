package ufrn.imd.crud.controller;

import jakarta.validation.constraints.Past;
import lombok.Builder;
import lombok.Getter;
import lombok.With;
import org.hibernate.validator.constraints.br.CPF;
import ufrn.imd.crud.domain.Genero;

import java.util.Date;

@Builder
@Getter
@With
class ProfessorDto {
    private Long id;
    private String nome;
    @CPF
    private String cpf;
    private Integer matricula;
    private Genero genero;
    private String departamento;
    @Past
    private Date dataNascimento;
    private Float salario;
    private String disciplinaAssociada;
}
