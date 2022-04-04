package co.gov.banrep.kepiaa.commons.model;

import co.gov.banrep.kepiaa.commons.enums.EstadoProcesosSubprocesosEnum;
import lombok.*;
import org.hibernate.Hibernate;
import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity(name = "PROCESOS_X_EJECUCION")
public class ProcesosXEjecucion implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PROCESOS_EJECUCION")
  @SequenceGenerator(name = "SEQ_PROCESOS_EJECUCION", allocationSize = 1)
  @Column(name = "CONSECUTIVO", nullable = false)
  private Integer consecutivo;

  @Column(name = "ESTADO", length = 2)
  @Enumerated(EnumType.STRING)
  private EstadoProcesosSubprocesosEnum estado;

  @Column(name = "FECHA_ULTIMA_EJECUCION")
  private Date fechaUltimaEjecucion;

  @Column(name = "EJECUTADO", length = 1)
  private String ejecutado;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "PRC_CONSECUTIVO")
  private Procesos procesos;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "PREJ_CONSECUTIVO")
  private ProcesosEjecutados procesosEjecutados;

  @OneToMany(mappedBy = "procesosXEjecucion", orphanRemoval = true)
  private List<ErroresProceso> erroresProcesos = new ArrayList<>();

  @OneToMany(mappedBy = "procesosXEjecucion", orphanRemoval = true)
  private List<ProcesosLog> procesosLogs = new ArrayList<>();

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    ProcesosXEjecucion that = (ProcesosXEjecucion) o;
    return consecutivo != null && Objects.equals(consecutivo, that.consecutivo);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
