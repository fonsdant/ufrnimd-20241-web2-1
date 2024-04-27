package ufrn.imd.crud.repository;

import ufrn.imd.crud.domain.Genero;

import java.util.Date;

public record AlunoEntity(
    Long id,
    String nome,
    String cpf,
    Integer matricula,
    Genero genero,
    String curso,
    Date dataNascimento
) {
}
