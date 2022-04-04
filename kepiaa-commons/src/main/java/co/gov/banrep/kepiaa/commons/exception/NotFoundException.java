package co.gov.banrep.kepiaa.commons.exception;

import org.springframework.http.HttpStatus;

public class NotFoundException extends CustomException{

    public NotFoundException(String detalle){
        super(detalle,HttpStatus.NOT_FOUND);
    }

    public NotFoundException(String detalle,Throwable cause) {
        super(detalle, cause,HttpStatus.NOT_FOUND);
    }

}