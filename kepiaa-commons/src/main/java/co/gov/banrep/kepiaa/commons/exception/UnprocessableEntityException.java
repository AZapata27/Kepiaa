package co.gov.banrep.kepiaa.commons.exception;

import org.springframework.http.HttpStatus;

public class UnprocessableEntityException extends CustomException{

    public UnprocessableEntityException(String detalle){
        super(detalle, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    public UnprocessableEntityException(String detalle,Throwable cause) {
        super(detalle, cause,HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
