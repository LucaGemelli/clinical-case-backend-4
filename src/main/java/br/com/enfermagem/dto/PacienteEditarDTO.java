package br.com.enfermagem.dto;

import java.time.LocalDate;
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
public class PacienteEditarDTO extends PacienteDTO {

    private String informante;

    private Long sexo;

    private LocalDate dataNascimento;

    private Long quantidadeFilhos;

    private Long estadoCivil;

    private String profissao;

    private String endereco;

    private String naturalidade;

    private String motivoInternacao;

    private String diagnosticoMedico;

    private String historicoDoencaAtual;

    private String doencasGraveCronica;

    private Long doenca;

    private String doencaObs;

    private String medicamentoUsoDomiciliar;

    private String alergiasMedicamentos;

    private String alergiasAlimentar;

    private String alergiasOutras;

    private String doencasInfancia;

    private String tratamentosAnteriores;

    private String internacoesAnteriores;

    private String cirurgias;

    private Long historicoObstetricaGesta;

    private Long historicoObstetricaPara;

    private Long historicoObstetricaAborto;

    private String historicoFamiliar;

    private Long fumante;

    private String fumanteObs;

    private Long usoAlcool;

    private String usoAlcoolObs;

    private Long usoDrogas;

    private String usoDrogasObs;

    private Long historicoCancer;

    private String historicoCancerObs;

    private Long condicaoMoradia;

    private Long condicaoMoradiaSaneamentoBasico;

    private String condicaoMoradiaObs;

    private Long saneamentoBasico;

    private String saneamentoBasicoObs;

    private Long atividadeFisica;

    private Long atividadeFisicaQtde;

    private String atividadeFisicaObs;

    private String atividadeFisicaVezesTipo;

    private Long sonoRepouso;

    private Long sonoRepousoHrs;

    private String sonoRepousoHrsObs;

    private String habitosHigieneBanho;

    private String habitosHigieneBucal;

    private Long frutasVerduras;

    private Long carneVermelha;

    private Long peixe;

    private Long frangoSuco;

    private Long agua;

    private Long cafe;

    private Long leite;

    private Long fritura;

    private Long comeQuantasVezesDia;

    private String comeQuantasVezesDiaObs;

    private Long habitosAlimentares;

    private String habitosAlimentaresVezesDiaObs;

    private String equilibrioEmocional;

    private Long eliminacoesUrinarias;

    private String eliminacoesUrinariasObs;

    private Long eliminacoesUrinariasNormais;

    private String eliminacoesUrinariasAlteracoes;

    private Long eliminacoesIntestinais;

    private String eliminacoesIntestinaisObs;

    private Long atividadeSexual;

    private Long problemaSaude;

    private String problemaSaudeObs;

    private Long conhecimentoProblemaSaude;

    private String conhecimentoProblemaSaudeObs;

    private Long estadoNutricional;

    private Float peso;

    private Float altura;

    private Long sinaisVitaisDor;

    private String sinaisVitaisDorObs;

    private Float sinaisVitaisFR;

    private Float sinaisVitaisFCPULSO;

    private Float sinaisVitaisSAT;

    private Float sinaisVitaisPA;

    private Float sinaisVitaisTemp;

    private List<ComentarioEditarDTO> comentarios;

    private List<Fluxo24hsEditarDTO> fluxo24hs;

    private List<EvolucaoEditarDTO> evolucoes;

}
