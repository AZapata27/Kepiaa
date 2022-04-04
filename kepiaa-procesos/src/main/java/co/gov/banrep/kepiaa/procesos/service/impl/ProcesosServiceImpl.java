package co.gov.banrep.kepiaa.procesos.service.impl;

import co.gov.banrep.kepiaa.commons.dto.ProcesosDto;
import co.gov.banrep.kepiaa.commons.dto.DetalleProcesosDto;
import co.gov.banrep.kepiaa.commons.enums.EstadoProcesosSubprocesosEnum;
import co.gov.banrep.kepiaa.commons.exception.NotFoundException;
import co.gov.banrep.kepiaa.commons.model.Procesos;
import co.gov.banrep.kepiaa.commons.model.ProcesosXEjecucion;
import co.gov.banrep.kepiaa.commons.repository.*;
import co.gov.banrep.kepiaa.procesos.service.ProcesosService;
import co.gov.banrep.kepiaa.commons.dto.ProcesosEjecutadosDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProcesosServiceImpl implements ProcesosService {

    private final ProcesosEjecutadosRepository procesosEjecutadosRepository;
    private final ProcesosXEjecucionRepository procesosXEjecucionRepository;
    private final ProcesosRepository procesosRepository;
    private final ProcesosLogRepository procesosLogRepository;
    private final ErroresProcesoRepository erroresProcesoRepository;

    public ProcesosServiceImpl(ProcesosEjecutadosRepository procesosEjecutadosRepository,
                               ProcesosXEjecucionRepository procesosXEjecucionRepository,
                               ProcesosRepository procesosRepository,
                               ProcesosLogRepository procesosLogRepository,
                               ErroresProcesoRepository erroresProcesoRepository) {
        this.procesosEjecutadosRepository = procesosEjecutadosRepository;
        this.procesosXEjecucionRepository = procesosXEjecucionRepository;
        this.procesosRepository = procesosRepository;
        this.procesosLogRepository = procesosLogRepository;
        this.erroresProcesoRepository = erroresProcesoRepository;
    }


    public Page<ProcesosEjecutadosDto> getProcesosEjecutados(Pageable pageable){
        return procesosEjecutadosRepository.findAllProcesosEjecutadosOrderDesc(pageable);
    }

    public List<ProcesosDto> getSubprocesosByConsecutivo(Integer consecutivo){

        Optional<ProcesosXEjecucion> procesosXEjecucion = procesosXEjecucionRepository.findById(consecutivo);

        Procesos procesos = procesosXEjecucion.orElseThrow(() -> new NotFoundException("No se encontro consecutivo")).getProcesos();

        return procesosRepository.findSubprocesosByConsecutivoPadre(procesos.getConsecutivo());
    }


    public List<DetalleProcesosDto> getErroresByConsecutivo(Integer consecutivo) {

        return erroresProcesoRepository.findByProcesosXEjecucionConsecutivoOrderByFechaHoraDesc(consecutivo);

    }

    public List<DetalleProcesosDto> getLogsByConsecutivo(Integer consecutivo) {

        return procesosLogRepository
                .findByProcesosXEjecucionConsecutivoOrderByFechaHoraDesc(consecutivo);

    }

    public Page<ProcesosEjecutadosDto> getProcesosEjecutadosByFiltros(Pageable pageable,
                                                                      Integer numeroProcesoEjecutado,
                                                                      String nombreProceso,
                                                                      String nombreSubproceso,
                                                                      Date fechaInicio,
                                                                      EstadoProcesosSubprocesosEnum estadoProceso){

        return procesosEjecutadosRepository.findAllProcesosEjecutadosOrderDescFiltradoTotal(pageable,
                numeroProcesoEjecutado,
                nombreProceso,
                estadoProceso == null ? null : estadoProceso.toString());
    }
}
