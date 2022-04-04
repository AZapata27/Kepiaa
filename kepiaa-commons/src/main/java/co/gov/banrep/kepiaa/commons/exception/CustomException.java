package co.gov.banrep.kepiaa.commons.exception;

import org.springframework.http.HttpStatus;

public abstract class CustomException extends RuntimeException{

    private final HttpStatus httpStatus;

    protected CustomException(String detalle,HttpStatus httpStatus){
        super(detalle);
        this.httpStatus =httpStatus;
    }

    protected CustomException(String detalle,Throwable cause,HttpStatus httpStatus) {
        super(detalle, cause);
        this.httpStatus =httpStatus;
    }

    public HttpStatus getHttpStatus(){
        return this.httpStatus;
    }
}
