package br.com.enfermagem.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(exclude = "paciente")
@ToString(exclude = "paciente")
@Table(name = "comentarios")
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dataHora;

    private String descricaoComentario;

    @ManyToOne
    @JoinColumn(name = "idcomentariopaciente")
    @JsonIgnoreProperties({"usuario", "caso", "comentarios", "fluxo24hsList", "evolucoes"})
    private Paciente paciente;
}
