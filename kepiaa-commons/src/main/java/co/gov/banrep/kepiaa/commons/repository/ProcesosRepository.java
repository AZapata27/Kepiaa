package co.gov.banrep.kepiaa.commons.repository;

import co.gov.banrep.kepiaa.commons.dto.ProcesosDto;
import co.gov.banrep.kepiaa.commons.model.Procesos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProcesosRepository extends JpaRepository<Procesos, Integer> {


    @Query("SELECT new co.gov.banrep.kepiaa.commons.dto.ProcesosDto( p.consecutivo,p.nombre,p.descripcion )" +
            "FROM PROCESOS p WHERE p.procesoPadre.consecutivo = ?1")
    List<ProcesosDto> findSubprocesosByConsecutivoPadre(Integer consecutivo);


}