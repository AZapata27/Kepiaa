package co.gov.banrep.kepiaa.commons.dto;

import co.gov.banrep.kepiaa.commons.enums.EstadoProcesosSubprocesosEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Getter
@AllArgsConstructor
@Builder
public class ProcesosEjecutadosDto implements Serializable {

    @JsonProperty(value = "id" ,index = 1)
    private Integer procesoXEjecucionConsecutivo;
    @NotNull
    @NotEmpty
    private Integer numeroProcesoEjecutado;
    private Integer procesoConsecutivo;
    private String nombreProceso;
    private String nombreSubproceso;
    private Date fechaInicio;
    private EstadoProcesosSubprocesosEnum estadoProceso;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProcesosEjecutadosDto that = (ProcesosEjecutadosDto) o;
        return Objects.equals(procesoXEjecucionConsecutivo, that.procesoXEjecucionConsecutivo) && Objects.equals(numeroProcesoEjecutado, that.numeroProcesoEjecutado) && Objects.equals(nombreProceso, that.nombreProceso) && Objects.equals(nombreSubproceso, that.nombreSubproceso) && Objects.equals(fechaInicio, that.fechaInicio) && Objects.equals(estadoProceso, that.estadoProceso);
    }

    @Override
    public int hashCode() {
        return Objects.hash(procesoXEjecucionConsecutivo, numeroProcesoEjecutado, nombreProceso, nombreSubproceso, fechaInicio, estadoProceso);
    }
}
