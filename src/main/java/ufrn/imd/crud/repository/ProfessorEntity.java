package ufrn.imd.crud.repository;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.With;
import ufrn.imd.crud.domain.Genero;

import java.util.Date;

@Entity
@Table(name = "professores")
@Builder
@Getter
@With
public class ProfessorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Boolean ativo;
    private String nome;
    private String cpf;
    private Integer matricula;
    private Genero genero;
    private String departamento;
    private Date dataNascimento;
    private Float salario;
    private String disciplinaAssociada;
}
