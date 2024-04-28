package ufrn.imd.crud.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ufrn.imd.crud.repository.ProfessorEntity;
import ufrn.imd.crud.repository.ProfessorRepository;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/professores")
final class ProfessorController {
    private final ProfessorRepository repository;

    @Autowired
    ProfessorController(final ProfessorRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    Collection<ProfessorDto> getAll() {
        return repository
            .findAll()
            .stream()
            .map(ProfessorMapper::toProfessorDto)
            .collect(Collectors.toSet());
    }

    @GetMapping("/{id}")
    ResponseEntity<ProfessorDto> getById(@PathVariable final Long id) {
        return repository
            .findById(id)
            .map(ProfessorMapper::toProfessorDto)
            .map(professorDto -> ResponseEntity.ok().body(professorDto))
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ProfessorDto postProfessor(@RequestBody @Valid final ProfessorDto professorDto) {
        final var professorEntity = ProfessorMapper.toProfessorEntity(professorDto);
        repository.save(professorEntity);
        return ProfessorMapper.toProfessorDto(professorEntity);
    }

    @PutMapping
    ResponseEntity<ProfessorDto> putProfessor(@RequestBody @Valid final ProfessorDto toUpdate) {
        ResponseEntity<ProfessorDto> result;
        if (toUpdate.getId() == null) {
            result = ResponseEntity.badRequest().build();
        } else {
            result = repository
                .findById(toUpdate.getId())
                .map(ProfessorMapper::toProfessorDto)
                .map(saved -> ProfessorMerger.merge(saved, toUpdate))
                .map(ProfessorMapper::toProfessorEntity)
                .map(repository::save)
                .map(ProfessorMapper::toProfessorDto)
                .map(saved -> ResponseEntity.ok().body(saved))
                .orElseGet(() -> ResponseEntity.notFound().build());
        }
        return result;
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Object> deleteProfessor(
        @RequestHeader("logical") final Boolean logical,
        @PathVariable final Long id
    ) {
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
            .map(professorEntity -> professorEntity.withAtivo(false))
            .map(repository::save)
            .map(ProfessorMapper::toProfessorDto)
            .map(professorDto -> ResponseEntity.ok().build())
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    private ResponseEntity<Object> deletePhysical(final Long id) {
        return repository
            .findById(id)
            .map(ProfessorEntity::getId)
            .map(foundId -> {
                repository.deleteById(foundId);
                return ResponseEntity.ok().build();
            })
            .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
