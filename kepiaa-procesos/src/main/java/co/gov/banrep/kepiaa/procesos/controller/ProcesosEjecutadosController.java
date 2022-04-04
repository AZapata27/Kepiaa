package co.gov.banrep.kepiaa.procesos.controller;

import co.gov.banrep.kepiaa.commons.dto.DetalleProcesosDto;
import co.gov.banrep.kepiaa.commons.enums.EstadoProcesosSubprocesosEnum;
import co.gov.banrep.kepiaa.procesos.service.impl.ProcesosServiceImpl;
import co.gov.banrep.kepiaa.commons.dto.ProcesosDto;
import co.gov.banrep.kepiaa.commons.dto.ProcesosEjecutadosDto;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/procesos-ejecutados")
public class ProcesosEjecutadosController {

    private final ProcesosServiceImpl procesosServiceImpl;


    @Operation(summary = "Obtiene todos los procesos ejecutados, con paginacion por defecto.",
            description = "Se debe relizar la implementacion con el paginador por defecto del frontend para un mejor uso")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<ProcesosEjecutadosDto>  getProcesosEjecutados(@ParameterObject Pageable pageable){

        return procesosServiceImpl.getProcesosEjecutados(pageable);
    }

    @GetMapping( value = "/busqueda",produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<ProcesosEjecutadosDto>
    getProcesosEjecutadosByFiltros ( @ParameterObject Pageable pageable,
                                     @RequestParam Integer numeroProcesoEjecutado,
                                     @RequestParam(required = false)  String nombreProceso,
                                     @RequestParam(required = false)  String nombreSubproceso,
                                     @RequestParam(required = false)  Date fechaInicio,
                                     @RequestParam(required = false)  EstadoProcesosSubprocesosEnum estadoProceso){


        return procesosServiceImpl.getProcesosEjecutadosByFiltros(pageable,
                numeroProcesoEjecutado,
                nombreProceso,
                nombreSubproceso,
                fechaInicio,
                estadoProceso);

    }



    @Operation(summary = "Obtiene los subprocesos dado el consecutivo de un proceso.")
    @GetMapping(value ="/{consecutivo}/subprocesos",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProcesosDto> getSubprocesosByConsecutivo(@PathVariable Integer consecutivo){

        return procesosServiceImpl.getSubprocesosByConsecutivo(consecutivo);
    }

    @Operation(summary = "Obtiene los errores dado el consecutivo de un proceso.")
    @GetMapping(value ="/{consecutivo}/errores",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DetalleProcesosDto> getErroresByConsecutivo(@PathVariable Integer consecutivo){

        return procesosServiceImpl.getErroresByConsecutivo(consecutivo);
    }


    @Operation(summary = "Obtiene los logs dado el consecutivo de un proceso.")
    @GetMapping(value ="/{consecutivo}/logs",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DetalleProcesosDto> getLogsByConsecutivo(@PathVariable Integer consecutivo){

        return procesosServiceImpl.getLogsByConsecutivo(consecutivo);
    }


}
