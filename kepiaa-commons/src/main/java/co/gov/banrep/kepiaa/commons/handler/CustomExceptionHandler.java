package co.gov.banrep.kepiaa.commons.handler;

import javax.persistence.PersistenceException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import co.gov.banrep.kepiaa.commons.exception.*;
import co.gov.banrep.kepiaa.commons.enums.ProfileEnum;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;


/**
 * Clase encargada de centralizar el tratamiento de excepciones de manera global
 * a lo largo de toda la plicacion, con el fin de estandarizar las response body de error
 * dando consistencia al api.
 *
 * <p>Cada {@code @ExceptionHandler} method, captura una serie de excepciones para su tratamiento,
 * si se encuentra un patron en una excepcion se debe agregar un nuevo {@code @ExceptionHandler}
 *
 *  <p>Extiende de {@link org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler}
    que es la encargada del tratamiento de excepciones de SPRING BOOT,
 *  se sobreescribe el {@code @handleExceptionInternal} para mapear su response body al estandar.
 *
 * <p> Implementa {@link org.springframework.boot.web.servlet.error.ErrorController}
    para capturar en el controlador {@code @handleInterceptorError} los errores que se
 *  ocacionen en la recepcion del conteneder de aplicaciones y que no corresponden
 *  a la logica de negocio del aplicativo para mapear su response body al estandar.
 *
 * @see org.springframework.boot.web.servlet.error.ErrorController
 * @see org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController
 * @see org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
 * @see org.springframework.web.bind.annotation.RestControllerAdvice
 * @see lombok.extern.log4j.Log4j &#64;Log4j
 **/
@RestControllerAdvice
@Controller
@Log4j2
public class CustomExceptionHandler extends ResponseEntityExceptionHandler implements ErrorController {

    @Value("${spring.profiles.active}")
    private String profileActive;

    /**
     * Captura y da manejo a las unicas excepciones permitadas lanzar por los desarolladores
     *
     * @param request Inyeccion de {@code @HttpServletRequest}
     * @param ex Exepcion interceptada de {@code @CustomException}
     * @return {@code @ExceptionResponseDTO} Estandar exception response
     */
    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ExceptionResponseDTO handleCustomBadRequestException(HttpServletRequest request, CustomException ex) {

        ExceptionResponseDTO exceptionResponseDto = getResponseCustomExceptionDto(ex,request);
        log.error(exceptionResponseDto.toString(),ex);
        return exceptionResponseDto;

    }
    @ExceptionHandler(ConflictException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ExceptionResponseDTO handleCustomConflictException(HttpServletRequest request, CustomException ex) {
        ExceptionResponseDTO exceptionResponseDto = getResponseCustomExceptionDto(ex,request);
        log.error(exceptionResponseDto.toString(),ex);
        return exceptionResponseDto;
    }
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponseDTO handleCustomNotFoundException(HttpServletRequest request, CustomException ex) {
        ExceptionResponseDTO exceptionResponseDto = getResponseCustomExceptionDto(ex,request);
        log.error(exceptionResponseDto.toString(),ex);
        return exceptionResponseDto;
    }
    @ExceptionHandler(UnprocessableEntityException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ExceptionResponseDTO handleCustomUnprocessableEntityException(HttpServletRequest request, CustomException ex) {
        ExceptionResponseDTO exceptionResponseDto = getResponseCustomExceptionDto(ex,request);
        log.error(exceptionResponseDto.toString(),ex);
        return exceptionResponseDto;
    }

    /**
     * Si no se capturo la excepcion en ningun {@code @ExceptionHandler} se toma este por defecto
     *
     * @param request Inyeccion de {@code @HttpServletRequest}
     * @param ex Exepcion interceptada de {@code @Exception}
     * @return {@code @ExceptionResponseDTO} Estandar exception response
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionResponseDTO handleException(HttpServletRequest request,Exception ex) {
        ExceptionResponseDTO exceptionResponseDto =  getResponseCustomExceptionDto(ex,request);
        log.error(exceptionResponseDto.toString(),ex);
        return exceptionResponseDto;
    }

    /**
     * Captura cualquier excepcion producido un erro en peticiones de
     * clientes RestTemplate internos
     *
     * @param request Inyeccion de {@code @HttpServletRequest}
     * @param ex Exepcion interceptada de {@code @RestClientException}
     * @return {@code @ExceptionResponseDTO} Estandar exception response
     */
    @ExceptionHandler(RestClientException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionResponseDTO handleInternalClientRestException(HttpServletRequest request, RestClientException ex) {
        ExceptionResponseDTO exceptionResponseDto = getResponseCustomExceptionDto(ex,request);
        log.error(exceptionResponseDto.toString(),ex);
        return exceptionResponseDto;
    }

    /**
     * Captura cualquier excepcion producida por el acceso a base de datos
     *
     * @param request Inyeccion de {@code @HttpServletRequest}
     * @param ex Exepcion interceptada de {@code @DataAccessException}
     * @return {@code @ExceptionResponseDTO} Estandar exception response
     */
    @ExceptionHandler(DataAccessException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionResponseDTO handleDataAccessException(HttpServletRequest request,DataAccessException ex) {
        ExceptionResponseDTO exceptionResponseDto = getResponseCustomExceptionDto(ex,request);
        log.error(exceptionResponseDto.toString(),ex);
        return exceptionResponseDto;
    }

    /**
     * Captura cualquier excepcion producida  por las sentencias SQL de persistencia a base de datos
     *
     * @param request Inyeccion de {@code @HttpServletRequest}
     * @param ex Exepcion interceptada de {@code @PersistenceException}
     * @return {@code @ExceptionResponseDTO} Estandar exception response
     */
    @ExceptionHandler(PersistenceException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionResponseDTO handlePersistenceException(HttpServletRequest request,PersistenceException ex) {
        ExceptionResponseDTO exceptionResponseDto = getResponseCustomExceptionDto(ex,request);
        log.error(exceptionResponseDto.toString(),ex);
        return exceptionResponseDto;
    }


    /**
     * Captura las excepciones de validacion en las request con anotacion {@code @Valid}
     *
     * @param webRequest Inyeccion de {@code @HttpServletRequest}
     * @param ex Exepcion interceptada de {@code @MethodArgumentNotValidException}
     * @return {@code @ExceptionResponseDTO} Estandar exception response
     *
     * @see org.springframework.web.bind.annotation.RequestBody
     * @see javax.validation.Valid
     * @see javax.validation.constraints
     */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest webRequest) {

        HttpServletRequest request  = ((ServletWebRequest) webRequest).getRequest();

        Map<String, String> validations = getValidationsMap(ex);

        ExceptionResponseDTO exceptionResponseDto = ExceptionResponseDTO.builder()
                //Si la excepcion no tiene causa no envia nada
                .cause(ex.getCause()!= null ? ex.getCause().getMessage() : null)
                .details("Se presentaron errores en la validacion de los campos: "+ String.join(", ", validations.keySet()))
                .timestamp(LocalDateTime.now())
                //Si esta en produccion NO muestra la URL completa del servidor por seguridad solo la URI
                .path(profileActive.equals(ProfileEnum.PROD) ?  request.getRequestURI() : request.getRequestURL().toString())
                .validations(validations)
                //Si esta en produccion NO muestra el stackTrace al frontend, para dev-test si lo imprime para un rapido debug
                .stackTrace(profileActive.equals(ProfileEnum.PROD) ? null : getStackTrace(ex)  )
                .build();


        log.error(exceptionResponseDto.toString(),ex);
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).headers(headers).body(exceptionResponseDto);
    }

    /**
     * Handler de excepciones de procesos internos de spring al recibir la peticion entrante
     *
     * @param webRequest Inyeccion de {@code @HttpServletRequest}
     * @param ex Exepcion interceptada de {@code @Exception}
     * @param status statusHttp generado {@code @HttpStatus}
     * @return {@code @ExceptionResponseDTO} Estandar exception response
     *
     * @see org.springframework.http.HttpStatus
     */
    @Override
    protected ResponseEntity<Object> handleExceptionInternal(
            Exception ex, @Nullable Object body, HttpHeaders headers, HttpStatus status, WebRequest webRequest) {

        HttpServletRequest request  = ((ServletWebRequest) webRequest).getRequest();
        ExceptionResponseDTO exceptionResponseDto = getResponseCustomExceptionDto(ex,request);
        log.error(exceptionResponseDto.toString(),ex,ex);
        return ResponseEntity.status(status).headers(headers).body(exceptionResponseDto);
    }


    /**
     *Controlador de servlet /error basico que captura las excepciones lanzadas directamente
     * desde el contenedor de aplicaciones Ej: JBOSS - TOMCAT - ETC.
     * Estos errores no son debido a logica de negocio de la aplicacion
     *
     * @param request Inyeccion de {@code @HttpServletRequest}
     * @return {@code @ExceptionResponseDTO} Estandar exception response
     */
    @RequestMapping("${server.error.path:${error.path:/error}}")
    public ResponseEntity<ExceptionResponseDTO>  handleInterceptorError(HttpServletRequest request) {

        WebRequest webRequest = new ServletWebRequest(request);
        HttpStatus status =getStatus(request);
        if (HttpStatus.NO_CONTENT ==status) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        String path = (String) webRequest.getAttribute(RequestDispatcher.ERROR_REQUEST_URI,RequestAttributes.SCOPE_REQUEST);
        String mensajeError = (String) webRequest.getAttribute(RequestDispatcher.ERROR_MESSAGE,RequestAttributes.SCOPE_REQUEST);
        Throwable exception = (Throwable) webRequest.getAttribute(RequestDispatcher.ERROR_EXCEPTION,RequestAttributes.SCOPE_REQUEST);
        exception = exception==null ? new ServletException("Error interno del servidor"): exception;


        if (HttpStatus.NOT_FOUND == status ) {
            ExceptionResponseDTO exceptionResponseDto =  ExceptionResponseDTO.builder()
                    //Si la excepcion no tiene causa no envia nada
                    .cause("Controlador no implementado")
                    .details("El path que esta tratando de acceder por method: "+request.getMethod()+", no existe porfavor verifique la peticion.")
                    .timestamp(LocalDateTime.now())
                    .path(path)
                    .build();

            log.error(exceptionResponseDto.toString(),exception);
            return new ResponseEntity<>(exceptionResponseDto,HttpStatus.NOT_FOUND);
        }

        ExceptionResponseDTO exceptionResponseDto =  ExceptionResponseDTO.builder()
                //Si la excepcion no tiene causa no envia nada
                .cause("Error en procesamiento del servidor")
                .details("Error no corresponde a la aplicacion porfavor informar al administrador del servidor o contenedor de aplicaciones:  error= "+mensajeError)
                .timestamp(LocalDateTime.now())
                .path(path)
                .stackTrace(profileActive.equals(ProfileEnum.PROD) ? null : getStackTrace((Exception) exception)  )
                .build();
        log.error(exceptionResponseDto.toString());
        return new ResponseEntity<>(exceptionResponseDto,status);

    }


    /**
     *
     * Metodo encargado de construir el DTO de respuesta para las excepciones se
     * setean algunos campos adicionales si no estan en produccion, como el {@code @stacktrace} y {@code @path}
     *
     * @param ex Exepcion interceptada de {@code @Exception}
     * @param request Inyeccion de {@code @HttpServletRequest}
     * @return {@code @ExceptionResponseDTO} Estandar exception response
     */
    private ExceptionResponseDTO getResponseCustomExceptionDto(Exception ex, HttpServletRequest request) {
        return ExceptionResponseDTO.builder()
                .timestamp(LocalDateTime.now())
                //Si esta en produccion NO muestra la URL completa del servidor por seguridad solo la URI
                .path( profileActive.equals(ProfileEnum.PROD) ?  request.getRequestURI() : request.getRequestURL().toString())
                //Si la excepcion no tiene causa no envia nada
                .cause( ex.getCause() == null ? null : ex.getCause().getMessage())
                .details(ex.getMessage())
                //Si esta en produccion NO muestra el stackTrace al frontend, para dev-test si lo imprime para un rapido debug
                .stackTrace(profileActive.equals(ProfileEnum.PROD) ? null : getStackTrace(ex)  )
                .build();
    }

    /**
     *  Formatea y recorta el StackTrace de la excepcion para que no sea tan grande al momento de enviarse
     *
     * @param ex Exepcion interceptada de {@code @Exception}
     * @return String StackTrace formateado para el body del repsonse
     */
    private String getStackTrace(Exception ex){
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        sw.flush();
        ex.printStackTrace(pw);
        String stackTrace = sw.toString();
        pw.flush();
        if(stackTrace.length()>2000){
            return stackTrace.substring(0,2000).replaceAll("\\r\\n\\tat", "                                               ");
        }else{
            return stackTrace.replaceAll("\\r\\n\\tat", "                                               ");
        }
    }

    /**
     * Recibe request y captura el status si no existe el estatus es {@code @HttpStatus.INTERNAL_SERVER_ERROR}
     * @param request HttpServletRequest enviada
     * @return HttpStatus capturada
     */
    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        try {
            return HttpStatus.valueOf(statusCode);
        }
        catch (Exception ex) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }


    /**
     * @param ex Recibe la excepcion validada
     * @return Map<String, String> la validations map
     */
    private Map<String, String> getValidationsMap(MethodArgumentNotValidException ex) {
        Map<String,String> validations = new HashMap<>();

        ex.getBindingResult().getAllErrors()
                .forEach(error->{
                    String fieldName =((FieldError) error).getField();
                    String messageError = error.getDefaultMessage();
                    validations.put(fieldName,messageError);
                });
        return validations;
    }




}
