package br.com.enfermagem.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UsuarioEditarDTO extends UsuarioDTO {

    private Long id;

    private String senha;

    private LocalDateTime dataHora;

    private String nome;

    private String email;

}
