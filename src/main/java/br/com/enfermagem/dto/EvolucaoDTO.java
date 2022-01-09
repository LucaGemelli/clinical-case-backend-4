package br.com.enfermagem.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EvolucaoDTO {

    private String descricaoSubjetivo;
    private String descricaoObjetivo;
    private String descricaoImpressao;
    private String descricaoConduta;
    private String descricaoCondigodiagnostico;
    private LocalDateTime dataHora;

}
