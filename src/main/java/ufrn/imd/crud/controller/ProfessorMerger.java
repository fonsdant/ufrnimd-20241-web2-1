package ufrn.imd.crud.controller;

import ufrn.imd.crud.repository.ProfessorEntity;

final class ProfessorMerger {
    static ProfessorDto merge(final ProfessorDto first, final ProfessorDto second) {
        var professorDto = first;
        if (second.getNome() != null) {
            professorDto = professorDto.withNome(second.getNome());
        }
        if (second.getMatricula() != null) {
            professorDto = professorDto.withMatricula(second.getMatricula());
        }
        if (second.getGenero() != null) {
            professorDto = professorDto.withGenero(second.getGenero());
        }
        if (second.getDepartamento() != null) {
            professorDto = professorDto.withDepartamento(second.getDepartamento());
        }
        if (second.getDataNascimento() != null) {
            professorDto = professorDto.withDataNascimento(second.getDataNascimento());
        }
        if (second.getSalario() != null) {
            professorDto = professorDto.withSalario(second.getSalario());
        }
        if (second.getDisciplinaAssociada() != null) {
            professorDto = professorDto.withDisciplinaAssociada(second.getDisciplinaAssociada());
        }
        return professorDto;
    }
}
