package co.gov.banrep.kepiaa.commons.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity(name = "CREDITOS")
public class Creditos {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CREDITOS")
  @SequenceGenerator(name = "SEQ_CREDITOS", sequenceName = "SEQ_CREDITOS", allocationSize = 1)
  @Column(name = "CONSECUTIVO", nullable = false)
  private String consecutivo;
  private String estado;
  private java.sql.Date fechaSolicitud;
  private String versionCredito;
  private String enRecomposicion;
  private String monto;
  private String plazo;
  private String tasaInteres;
  private String valorCuotaMensual;
  private String sucCodigo;
  private String licrConsecutivo;
  private String licrNumero;
  private String perConsecutivoTitular;
  private String periodicidad;
  private String siamCodigo;
  private String numeroSolicitud;
  private String numeroCredito;
  private Date fechaEnvioCarta;
  private String montoRenuncia;
  private String condicionado;
  private String observacionCondicionado;
  private Date fechaAsignacionAbogado;
  private String conceptoAbogado;
  private String observacionesEstTitulo;
  private String consecutivoGiro;
  private Date fechaDesembolso;
  private String reincidente;
  private String saldoDeuda;
  private String saldoMora;
  private String cuotasMora;
  private String diasMora;
  private Date fechaCartaAsignacion;
  private Date fechaDesistimiento;
  private Date fechaEstudio;
  private String perConsecutivoAsignado;
  private String ropeNumeroAsignado;
  private String cubaConsecutivo;
  private String simConsecutivo;
  private String causalRenuncia;
  private Date fechaCartaRenuncia;
  private String condicionSindicalTitu;
  private Date fechaAplicaSaldoFavor;
  private String tiopConsecutivo;
  private String numeroPagare;
  private String numeroContratoMutuo;
  private String fechaEntregarPagare;
  private String perConsecutivoPagare;
  private Date fechaImpresionFormatos;
  private String tipoTasaInteres;
  private String unidadTasaInteres;
  private Date fechaProximoVencimiento;
  private String numeroCartaDesembolso;
  private Date fechaCartaDesembolso;
  private Date fechaCierre;
  private String altura;
  private String numeroDelfos;
  private Date fechaDelfos;
  private String estadoCuenta;
  private String saldoInteresesAcumulados;
  private String afc;
  private String perConsecutivoFirma;
  private Date fechaCancelacion;
  private String cuotaAnual;

  @OneToMany(mappedBy = "creditos", orphanRemoval = true)
  private List<CreditosXProceso> creditosXProceso = new ArrayList<>();

}
