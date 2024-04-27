package ufrn.imd.crud.controller;

import ufrn.imd.crud.domain.Genero;

import java.util.Date;

record ProfessorDto(
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
