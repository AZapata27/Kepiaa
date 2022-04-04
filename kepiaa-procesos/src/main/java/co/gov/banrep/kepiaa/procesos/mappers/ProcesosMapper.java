package co.gov.banrep.kepiaa.procesos.mappers;

import co.gov.banrep.kepiaa.commons.dto.ProcesosDto;
import co.gov.banrep.kepiaa.commons.dto.DetalleProcesosDto;
import co.gov.banrep.kepiaa.commons.model.Procesos;
import co.gov.banrep.kepiaa.commons.model.ProcesosLog;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface ProcesosMapper {

    ProcesosDto procesosToProcesosDto(Procesos procesos);


    @Mapping(source = "procesosXEjecucion.consecutivo", target = "procesosXEjecucionConsecutivo")
    DetalleProcesosDto procesosLogToProcesosLogDto(ProcesosLog procesosLog);


}
