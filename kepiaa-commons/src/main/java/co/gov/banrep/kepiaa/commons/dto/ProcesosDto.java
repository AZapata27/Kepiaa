package co.gov.banrep.kepiaa.commons.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProcesosDto {

    private final Integer consecutivo;
    private final String  nombre;
    private final String  descripcion;

}
