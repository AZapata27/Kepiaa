package co.gov.banrep.kepiaa.commons.repository;

import co.gov.banrep.kepiaa.commons.dto.ProcesosEjecutadosDto;
import co.gov.banrep.kepiaa.commons.model.ProcesosEjecutados;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;

public interface ProcesosEjecutadosRepository extends JpaRepository<ProcesosEjecutados, Integer> {

    @Query(value = "SELECT new co.gov.banrep.kepiaa.commons.dto.ProcesosEjecutadosDto(" +
            " ProcesosXEjecucion.consecutivo" +
            ",ProcesosEjecutados.consecutivo" +
            ",Procesos.consecutivo" +
            ",case when Procesos.procesoPadre.consecutivo is null then Procesos.nombre else '' end " +
            ",case when Procesos.procesoPadre.consecutivo is not null then Procesos.nombre else ''  end " +
            ",ProcesosEjecutados.fechaInicio" +
            ",ProcesosXEjecucion.estado ) " +
            "FROM PROCESOS_EJECUTADOS  ProcesosEjecutados, PROCESOS_X_EJECUCION  ProcesosXEjecucion, PROCESOS Procesos  " +
            "WHERE ProcesosEjecutados.consecutivo = ProcesosXEjecucion.procesosEjecutados.consecutivo " +
            "AND Procesos.consecutivo = ProcesosXEjecucion.procesos.consecutivo " +
            "ORDER BY ProcesosEjecutados.consecutivo desc, Procesos.ordenSubproceso")
    Page<ProcesosEjecutadosDto> findAllProcesosEjecutadosOrderDesc(Pageable pageable);


    @Query(value = "SELECT new co.gov.banrep.kepiaa.commons.dto.ProcesosEjecutadosDto(" +
            " ProcesosXEjecucion.consecutivo" +
            ",ProcesosEjecutados.consecutivo" +
            ",Procesos.consecutivo" +
            ",case when Procesos.procesoPadre.consecutivo is null then Procesos.nombre else '' end " +
            ",case when Procesos.procesoPadre.consecutivo is not null then Procesos.nombre else ''  end " +
            ",ProcesosEjecutados.fechaInicio" +
            ",ProcesosXEjecucion.estado ) " +
            "FROM PROCESOS_EJECUTADOS  ProcesosEjecutados, PROCESOS_X_EJECUCION  ProcesosXEjecucion, PROCESOS Procesos  " +
            "WHERE ProcesosEjecutados.consecutivo = ProcesosXEjecucion.procesosEjecutados.consecutivo " +
            "AND Procesos.consecutivo = ProcesosXEjecucion.procesos.consecutivo " +
            "AND ProcesosEjecutados.consecutivo = ?1 " +
            "AND Procesos.nombre= ?2 " +
            "ORDER BY ProcesosEjecutados.consecutivo desc, Procesos.ordenSubproceso ")
    Page<ProcesosEjecutadosDto> findAllProcesosEjecutadosOrderDescFiltradoTotal(Pageable pageable, Integer consecutivo, String nombre, String estado);






}