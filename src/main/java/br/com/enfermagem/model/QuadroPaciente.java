package br.com.enfermagem.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = "caso")
@ToString(exclude = "caso")
@Entity
@Table(name = "quadropacientes")
public class QuadroPaciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "datahora")
    private LocalDateTime dataHora;

    @ManyToOne
    @JoinColumn(name = "idquadropacientecaso")
    @JsonIgnoreProperties("quadroPacientes")
    private Caso caso;
}
