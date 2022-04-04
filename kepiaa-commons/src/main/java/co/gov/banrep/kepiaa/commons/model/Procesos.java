package co.gov.banrep.kepiaa.commons.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity(name = "PROCESOS")
public class Procesos {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PROCESOS")
  @SequenceGenerator(name = "SEQ_PROCESOS", sequenceName = "SEQ_PROCESOS", allocationSize = 1)
  @Column(name = "CONSECUTIVO", nullable = false)
  private Integer consecutivo;

  @Column(name = "NOMBRE", unique = true, length = 50)
  private String nombre;

  @Column(name = "DESCRIPCION", length = 250)
  private String descripcion;

  @Column(name = "PERIODICIDAD_EJECUCION", length = 3)
  private String periodicidadEjecucion;

  @Column(name = "FECHA_INICIO")
  private Date fechaInicio;

  @Column(name = "PERMITIR_EJECUCION_EXTEMP", length = 21)
  private String permitirEjecucionExtemp;

  @Column(name = "ACTIVO", length = 1)
  private String activo;

  @Column(name = "PANTALLA", length = 2000)
  private String pantalla;

  @Column(name = "ORDEN_SUBPROCESO")
  private Integer ordenSubproceso;

  @Column(name = "ESTADO", length = 20)
  private String estado;

  @Column(name = "FECHA_ESTADO")
  private Date fechaEstado;

  @Column(name = "ORDEN_PROCESO")
  private Integer ordenProceso;

  @ManyToOne
  @JoinColumn(name = "PRC_CONSECUTIVO")
  private Procesos procesoPadre;

  @OneToMany(mappedBy = "procesoPadre")
  private List<Procesos> subprocesos = new ArrayList<>();

  @OneToMany(mappedBy = "procesos")
  private List<ProcesosXEjecucion> procesosXEjecucionList = new ArrayList<>();


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    Procesos procesos = (Procesos) o;
    return consecutivo != null && Objects.equals(consecutivo, procesos.consecutivo);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
