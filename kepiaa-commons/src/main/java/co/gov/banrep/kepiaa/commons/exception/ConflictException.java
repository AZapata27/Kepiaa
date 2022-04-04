package co.gov.banrep.kepiaa.commons.exception;

import org.springframework.http.HttpStatus;

public class ConflictException extends CustomException{

    public ConflictException(String detalle){
        super(detalle,HttpStatus.CONFLICT);
    }

    public ConflictException(String detalle,Throwable cause) {
        super(detalle, cause,HttpStatus.CONFLICT);
    }
}
