package ufrn.imd.crud.controller;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.With;
import ufrn.imd.crud.domain.Genero;

import java.util.Date;

@Builder
@With
class AlunoDto {
    @NotNull
    Long id;

    String nome;

    String cpf;

    Integer matricula;

    Genero genero;

    String curso;

    Date dataNascimento;
}
