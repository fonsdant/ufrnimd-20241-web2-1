package ufrn.imd.crud.repository;

import ufrn.imd.crud.domain.Genero;

import java.util.Date;

public record ProfessorEntity(
    Long id,
    String nome,
    String cpf,
    Integer matricula,
    Genero genero,
    String departamento,
    Date dataNascimento,
    Float salario,
    String disciplinaAssociada
) {
}
