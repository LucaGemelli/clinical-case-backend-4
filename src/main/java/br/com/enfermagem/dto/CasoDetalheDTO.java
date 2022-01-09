package br.com.enfermagem.dto;

import java.util.List;

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
public class CasoDetalheDTO extends CasoEditarDTO {

    private UsuarioDTO usuarioDto;

    private List<PacienteDTO> pacientes;

}
