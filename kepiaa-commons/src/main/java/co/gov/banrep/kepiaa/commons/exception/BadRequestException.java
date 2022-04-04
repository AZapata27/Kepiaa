package co.gov.banrep.kepiaa.commons.exception;

import org.springframework.http.HttpStatus;

public class BadRequestException extends CustomException{

    public BadRequestException(String detalle){
        super(detalle,HttpStatus.BAD_REQUEST);
    }

    public BadRequestException(String detalle,Throwable cause) {
        super(detalle, cause,HttpStatus.BAD_REQUEST);
    }

}
