package ufrn.imd.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ufrn.imd.crud.repository.AlunoEntity;
import ufrn.imd.crud.repository.AlunoRepository;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/alunos")
final class AlunoController {
    private final AlunoRepository repository;

    @Autowired
    AlunoController(final AlunoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    Collection<AlunoDto> getAll() {
        return repository
            .findAll()
            .stream()
            .map(AlunoMapper::toAlunoDTO)
            .collect(Collectors.toSet());
    }

    @GetMapping("/{id}")
    ResponseEntity<AlunoDto> getById(@PathVariable final Long id) {
        return repository
            .findById(id)
            .map(AlunoMapper::toAlunoDTO)
            .map(alunoDto -> ResponseEntity.ok().body(alunoDto))
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void postAluno(@RequestBody final AlunoDto alunoDto) {
        final var alunoEntity = AlunoMapper.toAlunoEntity(alunoDto);
        repository.save(alunoEntity);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    void putAluno(@RequestBody final AlunoDto alunoDto) {
        final var alunoEntity = AlunoMapper.toAlunoEntity(alunoDto);
        repository.save(alunoEntity);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    void deleteAluno(@RequestHeader("logic") final Boolean logical, @PathVariable final Long id) {
        if (logical) {
            repository
                .findById(id)
                .map();
        } else {
            repository.deleteById(id);
        }
    }

    private void deletePhysical() {

    }

    private void deleteLogical() {
    }

}
