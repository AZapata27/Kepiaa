package co.gov.banrep.kepiaa.commons.model;

import lombok.*;
import org.hibernate.Hibernate;
import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity(name = "PROCESOS_LOG")
public class ProcesosLog implements Serializable {


  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "PREE_CONSECUTIVO")
  private ProcesosXEjecucion procesosXEjecucion;

  @Id
  @Column(name = "NUMERO", length = 5)
  private String numero;

  @Column(name = "MENSAJE", length = 5)
  private String mensaje;

  @Column(name = "FECHA_HORA")
  private Date fechaHora;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    ProcesosLog that = (ProcesosLog) o;
    return procesosXEjecucion != null && Objects.equals(procesosXEjecucion, that.procesosXEjecucion);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
