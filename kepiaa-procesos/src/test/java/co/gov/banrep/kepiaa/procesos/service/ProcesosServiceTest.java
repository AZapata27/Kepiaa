package co.gov.banrep.kepiaa.procesos.service;

import co.gov.banrep.kepiaa.procesos.mocks.ProcesosEjecutadosDtoMock;
import co.gov.banrep.kepiaa.commons.dto.ProcesosEjecutadosDto;
import co.gov.banrep.kepiaa.commons.enums.EstadoProcesosSubprocesosEnum;
import co.gov.banrep.kepiaa.commons.repository.ProcesosEjecutadosRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;


@SpringBootTest
class ProcesosServiceTest {

    @Autowired
    private ProcesosService procesosService;

    @MockBean
    private ProcesosEjecutadosRepository procesosEjecutadosRepository;

    @Test
    void getProcesosEjecutados(){

        ProcesosEjecutadosDto prueba= new ProcesosEjecutadosDto(1, 1,1, "nombre prueba",
                "nombre subproceso", Date.valueOf(LocalDate.now()), EstadoProcesosSubprocesosEnum.OK);


        PageImpl<ProcesosEjecutadosDto> procesosEjecutadosDtoMocksList = new PageImpl<>(List.of(
                ProcesosEjecutadosDtoMock.ProcesosEjecutadosDtoMockBuilder(),
                ProcesosEjecutadosDtoMock.ProcesosEjecutadosDtoMockBuilder(),
                ProcesosEjecutadosDtoMock.ProcesosEjecutadosDtoMockBuilder()));

        when(procesosEjecutadosRepository.findAllProcesosEjecutadosOrderDesc(PageRequest.of(0,20)))
                .thenReturn(procesosEjecutadosDtoMocksList);

        Page<ProcesosEjecutadosDto> procesosEjecutadosDtos = procesosService.getProcesosEjecutados(PageRequest.of(0,20));


        assertTrue(procesosEjecutadosDtos.stream().allMatch(p->p.equals(prueba)));
    }
}
