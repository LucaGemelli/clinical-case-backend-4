package br.com.enfermagem.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(exclude = "paciente")
@ToString(exclude = "paciente")
@Table(name = "evolucoes")
public class Evolucao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 1, message = "Preencher Campo")
    private String descricaoSubjetivo;

    @NotBlank
    @Size(min = 1, message = "Preencher Campo")
    private String descricaoObjetivo;

    @NotBlank
    @Size(min = 1, message = "Preencher Campo")
    private String descricaoImpressao;

    @NotBlank
    @Size(min = 1, message = "Preencher Campo")
    private String descricaoConduta;

    @NotBlank
    @Size(min = 1, message = "Preencher Campo")
    private String descricaoCondigodiagnostico;

    private LocalDateTime dataHora;

    @ManyToOne
    @JoinColumn(name = "idEvolucaoPaciente")
    @JsonIgnoreProperties({"usuario", "caso", "comentarios", "fluxo24hsList", "evolucoes"})
    private Paciente paciente;

}
