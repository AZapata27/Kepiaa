
// imports Angular 
import { HttpErrorResponse, HttpEvent, HttpHandler, HttpInterceptor, HttpRequest, HttpResponse } from '@angular/common/http';
import { catchError, finalize, Observable, throwError } from 'rxjs';
import { Injectable } from '@angular/core';

// imports Servicio Spinner 
import { SpinnerService } from 'src/app/core/services/spinner.service';


/**
 * Interceptor genérico que se implementa en toda la aplicacion el 
 * cual permite capturar las peticiones HTTP y las respuestas.
 * implementa un loader que le indica al usuario que se está procesando
 * la solicitud. Implementa: 
 * - @constructor : se inyecta el servicio del spinner que se va a mostrar.
 * - @method intercept: metodo que hace parte de la interface HttpInterceptor
 *  intercepta las solicitudes y respuestas HTTP.
 * ->   @param request: dato de tipo HttpRequest recibe la peticion. 
 * ->   @param next : dato de tipo HttpHandler el cual transforma 
 *       una HttpRequest en una secuencia de HttpEvents, una de las cuales
 *       probablemente sea HttpResponse y se usa para retornar un observable
 *      de tipo HttpEvent
 * - @returns la respuesta de la peticion y establece la visibilidad del
 * loader a falso. 
 */



@Injectable()
export class SpinnerInterceptor implements HttpInterceptor {
  constructor(private loading: SpinnerService) { }


  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    this.loading.setLoading(true, request.url);

    return next
      .handle(request)
      .pipe(finalize(() => this.loading.setLoading(false, request.url)),
        catchError((error: HttpErrorResponse) => {
          return throwError(() => new Error("Ocurrió un error durente la peticion"))
        }));
  }




}