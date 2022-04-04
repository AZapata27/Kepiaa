package co.gov.banrep.kepiaa.commons.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

@Getter
public enum EstadoProcesosSubprocesosEnum {

    EE("EN EJECUCION"),
    NE("NO EJECUTADO"),
    OK("EJECUTADO SIN ERROR"),
    TE("EJECUTADO CON ERROR"),
    DEFAULT("-");;

    @JsonValue
    private final String descripcion;

    EstadoProcesosSubprocesosEnum(String descripcion){
        this.descripcion=descripcion;
    }
}
