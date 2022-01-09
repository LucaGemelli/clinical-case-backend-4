package br.com.enfermagem.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UsuarioDetalheDTO extends UsuarioEditarDTO {

	private List<PacienteDTO> pacientes;

    private List<CasoDTO> casos;
}
