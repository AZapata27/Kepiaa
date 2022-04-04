package co.gov.banrep.kepiaa.procesos.service;

import co.gov.banrep.kepiaa.commons.dto.DetalleProcesosDto;
import co.gov.banrep.kepiaa.commons.dto.ProcesosDto;
import co.gov.banrep.kepiaa.commons.dto.ProcesosEjecutadosDto;
import co.gov.banrep.kepiaa.commons.enums.EstadoProcesosSubprocesosEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

public interface ProcesosService {

    Page<ProcesosEjecutadosDto> getProcesosEjecutados(Pageable pageable);

    List<ProcesosDto> getSubprocesosByConsecutivo(Integer consecutivo);

    List<DetalleProcesosDto> getErroresByConsecutivo(Integer consecutivo);

    Page<ProcesosEjecutadosDto> getProcesosEjecutadosByFiltros(Pageable pageable,
                                                               Integer numeroProcesoEjecutado,
                                                               String nombreProceso,
                                                               String nombreSubproceso,
                                                               Date fechaInicio,
                                                               EstadoProcesosSubprocesosEnum estadoProceso);
}
