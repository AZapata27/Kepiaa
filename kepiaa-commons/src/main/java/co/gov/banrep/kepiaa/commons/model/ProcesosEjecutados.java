package co.gov.banrep.kepiaa.commons.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import co.gov.banrep.kepiaa.commons.dto.ProcesosEjecutadosDto;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;

@NamedNativeQuery(
        name = "prueba",
        resultSetMapping = "ProcesosEjecutadosDtoMapping",
        query = "SELECT " +
                "      ProcesosXEjecucion.consecutivo  as procesos_x_ejecucion " +
                "     ,ProcesosEjecutados.consecutivo as procesos_ejecutados " +
                "     ,Procesos.consecutivo as procesos " +
                "     ,case when Procesos.PRC_CONSECUTIVO is null then Procesos.nombre else '' end as nombre_proceso" +
                "     ,case when Procesos.PRC_CONSECUTIVO is not null then Procesos.nombre else ''  end as nombre_subproceso" +
                "     ,ProcesosEjecutados.FECHA_INICIO " +
                "     ,ProcesosXEjecucion.estado " +
                "FROM PROCESOS_EJECUTADOS  ProcesosEjecutados, PROCESOS_X_EJECUCION  ProcesosXEjecucion, PROCESOS Procesos " +
                "WHERE ProcesosEjecutados.consecutivo = ProcesosXEjecucion.PREJ_CONSECUTIVO " +
                "AND Procesos.consecutivo = ProcesosXEjecucion.PRC_CONSECUTIVO " +
                "AND ProcesosEjecutados.consecutivo = NVL(?1 , ProcesosEjecutados.consecutivo)" +
                "AND Procesos.nombre= NVL(?2 , Procesos.nombre) " +
                "AND ProcesosEjecutados.estado = NVL(?3 , ProcesosEjecutados.estado ) " +
                "ORDER BY ProcesosEjecutados.consecutivo desc, Procesos.ORDEN_SUBPROCESO ")
@SqlResultSetMapping(name = "ProcesosEjecutadosDtoMapping",
        classes = @ConstructorResult( targetClass = ProcesosEjecutadosDto.class,
                columns = {@ColumnResult(name = "PROCESOS_X_EJECUCION"),
                        @ColumnResult(name = "PROCESOS_EJECUTADOS"),
                        @ColumnResult(name = "PROCESOS"),
                        @ColumnResult(name = "NOMBRE_PROCESO"),
                        @ColumnResult(name = "NOMBRE_SUBPROCESO"),
                        @ColumnResult(name = "FECHA_INICIO"),
                        @ColumnResult(name = "ESTADO")}))
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity(name = "PROCESOS_EJECUTADOS")
public class ProcesosEjecutados {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PROCESOS_EJECUTADOS")
  @SequenceGenerator(name = "SEQ_PROCESOS_EJECUTADOS", sequenceName = "SEQ_PROCESOS_EJECUTADOS", allocationSize = 1)
  @Column(name = "CONSECUTIVO", nullable = false)
  private Integer consecutivo;

  @Column(name = "FECHA_INICIO")
  private Date fechaInicio;

  @Column(name = "ESTADO", length = 3)
  private String estado;

  @Column(name = "FECHA_FINALIZACION")
  private Date fechaFinalizacion;

  @Column(name = "PARAMETROS", length = 4000)
  private String parametros;

  @Column(name = "COD_LOCALIDAD_INICIO")
  private Integer codLocalidadInicio;

  @Column(name = "COD_LOCALIDAD_FIN")
  private Integer codLocalidadFin;

  @Column(name = "CRITERIO_COBERTURA", length = 2)
  private String criterioCobertura;

  @Column(name = "PROCESO_TERMINADO", length = 1)
  private String procesoTerminado;

  @Column(name = "LINEA_CREDITO", length = 4)
  private String lineaCredito;

  @Column(name = "TIPO_LIQUIDACION", length = 1)
  private String tipoLiquidacion;

  @Column(name = "CENTRO_COSTO", length = 15)
  private String centroCosto;

  @Column(name = "TIPO_NOMINA")
  private Integer tipoNomina;

  @OneToMany(mappedBy = "procesosEjecutados", orphanRemoval = true)
  private List<CreditosXProceso> creditosXProceso = new ArrayList<>();

  @OneToMany(mappedBy = "procesosEjecutados", orphanRemoval = true)
  private List<ProcesosXEjecucion> procesosXEjecucion = new ArrayList<>();


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    ProcesosEjecutados that = (ProcesosEjecutados) o;
    return consecutivo != null && Objects.equals(consecutivo, that.consecutivo);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
