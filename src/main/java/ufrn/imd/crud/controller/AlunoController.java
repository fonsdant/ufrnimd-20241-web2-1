package ufrn.imd.crud.controller;

import jakarta.validation.Valid;
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
            .map(AlunoMapper::toAlunoDto)
            .collect(Collectors.toSet());
    }

    @GetMapping("/{id}")
    ResponseEntity<AlunoDto> getById(@PathVariable final Long id) {
        return repository
            .findById(id)
            .map(AlunoMapper::toAlunoDto)
            .map(alunoDto -> ResponseEntity.ok().body(alunoDto))
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    AlunoDto postAluno(@RequestBody @Valid final AlunoDto alunoDto) {
        final var alunoEntity = AlunoMapper.toAlunoEntity(alunoDto);
        repository.save(alunoEntity);
        return AlunoMapper.toAlunoDto(alunoEntity);
    }

    @PutMapping
    ResponseEntity<AlunoDto> putAluno(@RequestBody @Valid final AlunoDto toUpdate) {
        ResponseEntity<AlunoDto> result;
        if (toUpdate.getId() == null) {
            result = ResponseEntity.badRequest().build();
        } else {
            result = repository
                .findById(toUpdate.getId())
                .map(AlunoMapper::toAlunoDto)
                .map(saved -> AlunoMerger.merge(saved, toUpdate))
                .map(AlunoMapper::toAlunoEntity)
                .map(repository::save)
                .map(AlunoMapper::toAlunoDto)
                .map(saved -> ResponseEntity.ok().body(saved))
                .orElseGet(() -> ResponseEntity.notFound().build());
        }
        return result;
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Object> deleteAluno(@RequestHeader("logical") final Boolean logical, @PathVariable final Long id) {
        ResponseEntity<Object> result;
        if (logical) {
            result = deleteLogical(id);
        } else {
            result = deletePhysical(id);
        }
        return result;
    }

    private ResponseEntity<Object> deleteLogical(final Long id) {
        return repository
            .findById(id)
            .map(alunoEntity -> alunoEntity.withAtivo(false))
            .map(repository::save)
            .map(AlunoMapper::toAlunoDto)
            .map(alunoDto -> ResponseEntity.ok().build())
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    private ResponseEntity<Object> deletePhysical(final Long id) {
        return repository
            .findById(id)
            .map(AlunoEntity::getId)
            .map(foundId -> {
                repository.deleteById(foundId);
                return ResponseEntity.ok().build();
            })
            .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
