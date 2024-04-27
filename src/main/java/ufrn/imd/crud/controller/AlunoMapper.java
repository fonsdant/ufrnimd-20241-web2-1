package ufrn.imd.crud.controller;

import ufrn.imd.crud.repository.AlunoEntity;

final class AlunoMapper {
    static AlunoDto toAlunoDTO(final AlunoEntity alunoEntity) {
        return new AlunoDto.builder.(
            alunoEntity.id(),
            alunoEntity.nome(),
            alunoEntity.cpf(),
            alunoEntity.matricula(),
            alunoEntity.genero(),
            alunoEntity.curso(),
            alunoEntity.dataNascimento()
        );
    }

    static AlunoEntity toAlunoEntity(final AlunoDto alunoDto) {
        return new AlunoEntity(
            alunoDto.id(),
            alunoDto.nome(),
            alunoDto.cpf(),
            alunoDto.matricula(),
            alunoDto.genero(),
            alunoDto.curso(),
            alunoDto.dataNascimento()
        );
    }
}
