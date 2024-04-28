package ufrn.imd.crud.controller;

import lombok.Builder;
import lombok.Getter;
import lombok.With;
import org.hibernate.validator.constraints.br.CPF;
import ufrn.imd.crud.domain.Genero;

import java.util.Date;

@Builder
@Getter
@With
class AlunoDto {
    private Long id;
    private String nome;
    @CPF
    private String cpf;
    private Integer matricula;
    private Genero genero;
    private String curso;
    private Date dataNascimento;
}
