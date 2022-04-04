package co.gov.banrep.kepiaa.procesos.mocks;

import co.gov.banrep.kepiaa.commons.dto.ProcesosEjecutadosDto;
import co.gov.banrep.kepiaa.commons.enums.EstadoProcesosSubprocesosEnum;

import java.sql.Date;
import java.time.LocalDate;

public class ProcesosEjecutadosDtoMock {

    static public ProcesosEjecutadosDto ProcesosEjecutadosDtoMockBuilder() {
        return new ProcesosEjecutadosDto(1, 1, 1,"nombre prueba",
                "nombre subproceso", Date.valueOf(LocalDate.now()), EstadoProcesosSubprocesosEnum.OK);
    }
}
