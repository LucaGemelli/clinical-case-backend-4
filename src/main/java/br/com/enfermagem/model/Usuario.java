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
@EqualsAndHashCode(exclude = {"pacientes", "casos"})
@ToString(exclude = {"pacientes", "casos"})
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "login")
    private String login;

    @Column(name = "senha")
    private String senha;

    @Column(name = "nome")
    private String nome;

    @Column(name = "datahora")
    private LocalDateTime dataHora;

    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    @JsonIgnoreProperties("idPacienteUsuario")
    @JsonIgnore
    private List<Paciente> pacientes;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    @JsonIgnoreProperties("idCasoUsuario")
    @JsonIgnore
    private List<Caso> casos;
}
