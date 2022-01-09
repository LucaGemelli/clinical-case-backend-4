package br.com.enfermagem.dto;

import br.com.enfermagem.model.Paciente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ComentarioDetalheDTO extends ComentarioEditarDTO {

    private Paciente paciente;
}
