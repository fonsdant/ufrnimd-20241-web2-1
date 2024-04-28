package ufrn.imd.crud.controller;

import ufrn.imd.crud.repository.AlunoEntity;

final class AlunoMapper {
    static AlunoDto toAlunoDto(final AlunoEntity alunoEntity) {
        return AlunoDto
            .builder()
            .id(alunoEntity.getId())
            .nome(alunoEntity.getNome())
            .cpf(alunoEntity.getCpf())
            .matricula(alunoEntity.getMatricula())
            .genero(alunoEntity.getGenero())
            .curso(alunoEntity.getCurso())
            .dataNascimento(alunoEntity.getDataNascimento())
            .build();
    }

    static AlunoEntity toAlunoEntity(final AlunoDto alunoDto) {
        return AlunoEntity
            .builder()
            .nome(alunoDto.getNome())
            .cpf(alunoDto.getCpf())
            .matricula(alunoDto.getMatricula())
            .genero(alunoDto.getGenero())
            .curso(alunoDto.getCurso())
            .dataNascimento(alunoDto.getDataNascimento())
            .build();
    }
}
