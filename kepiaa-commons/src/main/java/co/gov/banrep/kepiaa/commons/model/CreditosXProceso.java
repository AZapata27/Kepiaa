package co.gov.banrep.kepiaa.commons.model;

import lombok.*;
import org.hibernate.Hibernate;
import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity(name = "CREDITOS_X_PROCESO")
public class CreditosXProceso {

  @Id
  private String consecutivo;

  @ManyToOne
  @JoinColumn(name = "CRE_CONSECUTIVO")
  private Creditos creditos;

  @ManyToOne
  @JoinColumn(name = "PREJ_CONSECUTIVO")
  private ProcesosEjecutados procesosEjecutados;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    CreditosXProceso that = (CreditosXProceso) o;
    return consecutivo != null && Objects.equals(consecutivo, that.consecutivo);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
