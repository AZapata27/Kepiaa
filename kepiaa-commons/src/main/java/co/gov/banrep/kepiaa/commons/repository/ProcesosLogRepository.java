package co.gov.banrep.kepiaa.commons.repository;

import co.gov.banrep.kepiaa.commons.dto.DetalleProcesosDto;
import co.gov.banrep.kepiaa.commons.model.ProcesosLog;
import co.gov.banrep.kepiaa.commons.model.ProcesosXEjecucion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProcesosLogRepository extends JpaRepository<ProcesosLog, ProcesosXEjecucion> {

    @Query("select new co.gov.banrep.kepiaa.commons.dto.DetalleProcesosDto( p.mensaje , p.fechaHora ) from PROCESOS_LOG p " +
            "where p.procesosXEjecucion.consecutivo = ?1 " +
            "order by p.fechaHora DESC")
    List<DetalleProcesosDto> findByProcesosXEjecucionConsecutivoOrderByFechaHoraDesc(Integer consecutivo);

}