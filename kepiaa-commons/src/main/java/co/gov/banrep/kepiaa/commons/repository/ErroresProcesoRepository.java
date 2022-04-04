package co.gov.banrep.kepiaa.commons.repository;

import co.gov.banrep.kepiaa.commons.dto.DetalleProcesosDto;
import co.gov.banrep.kepiaa.commons.model.ErroresProceso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ErroresProcesoRepository extends JpaRepository<ErroresProceso, String> {

    @Query("select new co.gov.banrep.kepiaa.commons.dto.DetalleProcesosDto( e.mensaje, e.fechaHora) from ERRORES_PROCESO e " +
            "where e.procesosXEjecucion.consecutivo = :consecutivo " +
            "order by e.fechaHora DESC" )
    List<DetalleProcesosDto> findByProcesosXEjecucionConsecutivoOrderByFechaHoraDesc(Integer consecutivo);



}