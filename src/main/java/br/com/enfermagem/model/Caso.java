package br.com.enfermagem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"usuario", "pacientes", "quadroPacientes"})
@ToString(exclude = {"usuario", "pacientes", "quadroPacientes"})
@Table(name = "casos")
public class Caso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "identificacao")
    private String identificacao;

    @Column(name = "code")
    private String code;

    @Column(name = "datahora")
    private LocalDateTime dataHora;

    @ManyToOne
    @JoinColumn(name = "idcasousuario")
    @JsonIgnoreProperties({"casos", "pacientes"})
    private Usuario usuario;

    @OneToMany(mappedBy = "caso", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Paciente> pacientes;

    @OneToMany(mappedBy = "caso", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<QuadroPaciente> quadroPacientes;
}
