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
public class Fluxo24hsDTO {

    private LocalDateTime dataHora;
    private String observacoes;
    private Long cod;
    private String pa;
    private String fc;
    private String fr;
    private String tax;
    private String dor;
    private String sat;
    private String pvc;
    private String hgt;
    private String administrados;
    private String eliminados;
}
