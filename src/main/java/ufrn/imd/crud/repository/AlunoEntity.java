package ufrn.imd.crud.repository;

import jakarta.persistence.*;
import lombok.*;
import ufrn.imd.crud.domain.Genero;

import java.time.LocalDate;

@Entity
@Table(name = "alunos")
@Builder
@Getter
@With
@AllArgsConstructor
@NoArgsConstructor
public final class AlunoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Boolean ativo;
    private String nome;
    private String cpf;
    private Integer matricula;
    private Genero genero;
    private String curso;
    private LocalDate dataNascimento;
}
