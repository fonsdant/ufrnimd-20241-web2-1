package ufrn.imd.crud.repository;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.With;
import ufrn.imd.crud.domain.Genero;

import java.util.Date;

@Entity
@Table(name = "alunos")
@Builder
@Getter
@With
public class AlunoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    Boolean ativo;
    String nome;
    String cpf;
    Integer matricula;
    Genero genero;
    String curso;
    Date dataNascimento;
}
