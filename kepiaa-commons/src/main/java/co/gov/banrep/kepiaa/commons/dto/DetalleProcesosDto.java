package co.gov.banrep.kepiaa.commons.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


/**
 * Clase encargada de contener la informacion de un proceso ejecutado como sus ERRORES Y LOGS
 */
@Getter
@Setter
@AllArgsConstructor
public class DetalleProcesosDto  {

   private  String mensaje;
   private  Date fechaHora;

}
