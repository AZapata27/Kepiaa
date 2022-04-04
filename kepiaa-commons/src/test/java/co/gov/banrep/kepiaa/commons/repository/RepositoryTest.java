package co.gov.banrep.kepiaa.commons.repository;


import co.gov.banrep.kepiaa.commons.dto.ProcesosEjecutadosDto;
import co.gov.banrep.kepiaa.commons.enums.EstadoProcesosSubprocesosEnum;
import co.gov.banrep.kepiaa.commons.model.Procesos;
import co.gov.banrep.kepiaa.commons.model.ProcesosEjecutados;
import co.gov.banrep.kepiaa.commons.model.ProcesosXEjecucion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.sql.Date;
import java.time.LocalDate;

@DataJpaTest
class RepositoryTest {

    @Autowired
    private ProcesosXEjecucionRepository procesosXEjecucionRepository;

    @Autowired
    private ProcesosEjecutadosRepository procesosEjecutadosRepository;

    static final LocalDate dateActual = LocalDate.now();


    @Test
    void findAllProcesosEjecutadosOrderDesc(){

        EstadoProcesosSubprocesosEnum estado =EstadoProcesosSubprocesosEnum.valueOf("OK");
        String nombreProceso = "prueba nombre proceso";

        ProcesosXEjecucion procesosXEjecucion =  new ProcesosXEjecucion();
        procesosXEjecucion.setEstado(estado);

        Procesos procesos = new Procesos();
        procesos.setNombre(nombreProceso);
        procesos.setOrdenSubproceso(1);

        procesosXEjecucion.setProcesos(procesos);

        ProcesosEjecutados procesosEjecutados = new ProcesosEjecutados();
        procesosEjecutados.setFechaInicio(Date.valueOf(dateActual));

        procesosXEjecucion.setProcesosEjecutados(procesosEjecutados);

        ProcesosXEjecucion saved = procesosXEjecucionRepository.save(procesosXEjecucion);

        Page<ProcesosEjecutadosDto> procesosXEjecucionList = procesosEjecutadosRepository.findAllProcesosEjecutadosOrderDesc(PageRequest.of(0, 20));

        ProcesosEjecutadosDto procesosEjecutadosDto = new ProcesosEjecutadosDto(
                saved.getConsecutivo(),
                saved.getProcesosEjecutados().getConsecutivo(),
                saved.getProcesos().getConsecutivo(),
                nombreProceso,"",
                Date.valueOf(dateActual),estado
        );

        Assertions.assertTrue(procesosXEjecucionList.stream()
                .anyMatch(p-> p.equals(procesosEjecutadosDto)));

    }


}
