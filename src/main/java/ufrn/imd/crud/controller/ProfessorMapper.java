package ufrn.imd.crud.controller;

import ufrn.imd.crud.repository.ProfessorEntity;

final class ProfessorMapper {
    static ProfessorDto toProfessorDto(final ProfessorEntity professorEntity) {
        return ProfessorDto
            .builder()
            .id(professorEntity.getId())
            .nome(professorEntity.getNome())
            .cpf(professorEntity.getCpf())
            .matricula(professorEntity.getMatricula())
            .genero(professorEntity.getGenero())
            .departamento(professorEntity.getDepartamento())
            .dataNascimento(professorEntity.getDataNascimento())
            .salario(professorEntity.getSalario())
            .disciplinaAssociada(professorEntity.getDisciplinaAssociada())
            .build();
    }

    static ProfessorEntity toProfessorEntity(final ProfessorDto professorDto) {
        return ProfessorEntity
            .builder()
            .nome(professorDto.getNome())
            .cpf(professorDto.getCpf())
            .matricula(professorDto.getMatricula())
            .genero(professorDto.getGenero())
            .departamento(professorDto.getDepartamento())
            .dataNascimento(professorDto.getDataNascimento())
            .salario(professorDto.getSalario())
            .disciplinaAssociada(professorDto.getDisciplinaAssociada())
            .build();
    }
}
