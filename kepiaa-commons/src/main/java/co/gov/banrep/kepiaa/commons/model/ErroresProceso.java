package co.gov.banrep.kepiaa.commons.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity(name = "ERRORES_PROCESO")
public class ErroresProceso {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ERRORES_PROCESO")
  @SequenceGenerator(name = "SEQ_ERRORES_PROCESO", sequenceName = "SEQ_ERRORES_PROCESO", allocationSize = 1)
  @Column(name = "CONSECUTIVO", nullable = false)
  private String consecutivo;

  @Column(name = "MENSAJE", length = 1000)
  private String mensaje;

  @Column(name = "FECHA_HORA")
  private Date fechaHora;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "PREE_CONSECUTIVO")
  private ProcesosXEjecucion procesosXEjecucion;

  @Column(name = "VECR_NUMERO", length = 3)
  private String vecrNumero;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "VECR_CRE_CONSECUTIVO")
  private Creditos creditos;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    ErroresProceso that = (ErroresProceso) o;
    return consecutivo != null && Objects.equals(consecutivo, that.consecutivo);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
