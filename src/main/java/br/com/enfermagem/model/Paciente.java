package br.com.enfermagem.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"usuario", "caso", "comentarios", "fluxo24hsList", "evolucoes"})
@EqualsAndHashCode(exclude = {"usuario", "caso", "comentarios", "fluxo24hsList", "evolucoes"})
@Table(name = "pacientes")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "datahora")
    private LocalDateTime dataHora;

    @Column(name = "informante")
    private String informante;

    @Column(name = "sexo")
    private Long sexo;

    @Column(name = "datanascimento")
    private LocalDate dataNascimento;

    @Column(name = "quantidadefilhos")
    private Long quantidadeFilhos;

    @Column(name = "estadocivil")
    private Long estadoCivil;

    @Column(name = "profissao")
    private String profissao;

    @Column(name = "endereco")
    private String endereco;

    @Column(name = "naturalidade")
    private String naturalidade;

    @Column(name = "motivointernacao")
    private String motivoInternacao;

    @Column(name = "diagnosticomedico")
    private String diagnosticoMedico;

    @Column(name = "historicodoencaatual")
    private String historicoDoencaAtual;

    @Column(name = "doencasgravecronica")
    private String doencasGraveCronica;

    @Column(name = "doenca")
    private Long doenca;

    @Column(name = "doencaobs")
    private String doencaObs;

    @Column(name = "medicamentousodomiciliar")
    private String medicamentoUsoDomiciliar;

    @Column(name = "alergiasmedicamentos")
    private String alergiasMedicamentos;

    @Column(name = "alergiasalimentar")
    private String alergiasAlimentar;

    @Column(name = "alergiasoutras")
    private String alergiasOutras;

    @Column(name = "doencasinfancia")
    private String doencasInfancia;

    @Column(name = "tratamentosanteriores")
    private String tratamentosAnteriores;

    @Column(name = "internacoesanteriores")
    private String internacoesAnteriores;

    @Column(name = "cirurgias")
    private String cirurgias;

    @Column(name = "historicoobstetricagesta")
    private Long historicoObstetricaGesta;

    @Column(name = "historicoobstetricapara")
    private Long historicoObstetricaPara;

    @Column(name = "historicoobstetricaaborto")
    private Long historicoObstetricaAborto;

    @Column(name = "historicofamiliar")
    private String historicoFamiliar;

    @Column(name = "fumante")
    private Long fumante;

    @Column(name = "fumanteobs")
    private String fumanteObs;

    @Column(name = "usoalcool")
    private Long usoAlcool;

    @Column(name = "usoalcoolobs")
    private String usoAlcoolObs;

    @Column(name = "usodrogas")
    private Long usoDrogas;

    @Column(name = "usodrogasobs")
    private String usoDrogasObs;

    @Column(name = "historicocancer")
    private Long historicoCancer;

    @Column(name = "historicocancerobs")
    private String historicoCancerObs;

    @Column(name = "condicaomoradia")
    private Long condicaoMoradia;

    @Column(name = "condicaomoradiasaneamentobasico")
    private Long condicaoMoradiaSaneamentoBasico;

    @Column(name = "condicaomoradiaobs")
    private String condicaoMoradiaObs;

    @Column(name = "saneamentobasico")
    private Long saneamentoBasico;

    @Column(name = "saneamentobasicoobs")
    private String saneamentoBasicoObs;

    @Column(name = "atividadefisica")
    private Long atividadeFisica;

    @Column(name = "atividadefisicaqtde")
    private Long atividadeFisicaQtde;

    @Column(name = "atividadefisicaobs")
    private String atividadeFisicaObs;

    @Column(name = "atividadefisicavezestipo")
    private String atividadeFisicaVezesTipo;

    @Column(name = "sonorepouso")
    private Long sonoRepouso;

    @Column(name = "sonorepousohrs")
    private Long sonoRepousoHrs;

    @Column(name = "sonorepousohrsobs")
    private String sonoRepousoHrsObs;

    @Column(name = "habitoshigienebanho")
    private String habitosHigieneBanho;

    @Column(name = "habitoshigienebucal")
    private String habitosHigieneBucal;

    @Column(name = "frutasverduras")
    private Long frutasVerduras;

    @Column(name = "carnevermelha")
    private Long carneVermelha;

    @Column(name = "peixe")
    private Long peixe;

    @Column(name = "frangosuco")
    private Long frangoSuco;

    @Column(name = "agua")
    private Long agua;

    @Column(name = "cafe")
    private Long cafe;

    @Column(name = "leite")
    private Long leite;

    @Column(name = "fritura")
    private Long fritura;

    @Column(name = "comequantasvezesdia")
    private Long comeQuantasVezesDia;

    @Column(name = "comequantasvezesdiaobs")
    private String comeQuantasVezesDiaObs;

    @Column(name = "habitosalimentares")
    private Long habitosAlimentares;

    @Column(name = "habitosalimentaresvezesdiaobs")
    private String habitosAlimentaresVezesDiaObs;

    @Column(name = "equilibrioemocional")
    private String equilibrioEmocional;

    @Column(name = "eliminacoesurinarias")
    private Long eliminacoesUrinarias;

    @Column(name = "eliminacoesurinariasobs")
    private String eliminacoesUrinariasObs;

    @Column(name = "eliminacoesurinariasnormais")
    private Long eliminacoesUrinariasNormais;

    @Column(name = "eliminacoesurinariasalteracoes")
    private String eliminacoesUrinariasAlteracoes;

    @Column(name = "eliminacoesintestinais")
    private Long eliminacoesIntestinais;

    @Column(name = "eliminacoesintestinaisobs")
    private String eliminacoesIntestinaisObs;

    @Column(name = "atividadesexual")
    private Long atividadeSexual;

    @Column(name = "problemasaude")
    private Long problemaSaude;

    @Column(name = "problemasaudeobs")
    private String problemaSaudeObs;

    @Column(name = "conhecimentoproblemasaude")
    private Long conhecimentoProblemaSaude;

    @Column(name = "conhecimentoproblemasaudeobs")
    private String conhecimentoProblemaSaudeObs;

    @Column(name = "estadonutricional")
    private Long estadoNutricional;

    @Column(name = "peso")
    private Float peso;

    @Column(name = "altura")
    private Float altura;

    @Column(name = "sinaisvitaisdor")
    private Long sinaisVitaisDor;

    @Column(name = "sinaisvitaisdorobs")
    private String sinaisVitaisDorObs;

    @Column(name = "sinaisvitaisFR")
    private Float sinaisVitaisFR;

    @Column(name = "sinaisvitaisFCPULSO")
    private Float sinaisVitaisFCPULSO;

    @Column(name = "sinaisvitaisSAT")
    private Float sinaisVitaisSAT;

    @Column(name = "sinaisvitaisPA")
    private Float sinaisVitaisPA;

    @Column(name = "sinaisvitaistemp")
    private Float sinaisVitaisTemp;

    @ManyToOne
    @JoinColumn(name = "idpacienteusuario")
    @JsonIgnoreProperties({"pacientes", "casos"})
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "idpacientecaso")
    @JsonIgnoreProperties({"pacientes", "usuario", "quadroPacientes"})
    private Caso caso;

    @OneToMany(mappedBy = "paciente", fetch = FetchType.LAZY)
    @JsonIgnoreProperties("paciente")
    private List<Comentario> comentarios;

    @OneToMany(mappedBy = "paciente", fetch = FetchType.LAZY)
    @JsonIgnoreProperties("paciente")
    private List<Fluxo24hs> fluxo24hsList;

    @OneToMany(mappedBy = "paciente", fetch = FetchType.LAZY)
    @JsonIgnoreProperties("paciente")
    private List<Evolucao> evolucoes;
}