package ufrn.imd.crud.controller;

final class AlunoMerger {
    static AlunoDto merge(final AlunoDto first, final AlunoDto second) {
        var alunoDto = first;
        if (second.getNome() != null) {
            alunoDto = alunoDto.withNome(second.getNome());
        }
        if (second.getCpf() != null) {
            alunoDto = alunoDto.withCpf(second.getCpf());
        }
        if (second.getMatricula() != null) {
            alunoDto = alunoDto.withMatricula(second.getMatricula());
        }
        if (second.getGenero() != null) {
            alunoDto = alunoDto.withGenero(second.getGenero());
        }
        if (second.getCurso() != null) {
            alunoDto = alunoDto.withCurso(second.getCurso());
        }
        if (second.getDataNascimento() != null) {
            alunoDto = alunoDto.withDataNascimento(second.getDataNascimento());
        }
        return alunoDto;
    }
}
