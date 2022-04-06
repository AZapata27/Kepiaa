import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { SubProceso } from '../models/subproceso.interface';
import { Informativa } from '../models/informativa.interface';
import { Observable } from 'rxjs';
import { Proceso } from '../models/proceso.interface';
import { Estados } from '../enums/estado.enum'; 


@Injectable({
  providedIn: 'root'
})
export class ProcesosServices {

  /*
  Consiste en el item que selecciona el usuario de los tres: 
  ( Subprocesos, Errores, Logs )el cual le indica que método
  tiene que consumir. 
  */

  itemSeleccionado: string = "";


  // Este objeto corresponde con el proceso que ha seleccionado
  // el usuario en la tabla
  procesoSeleccionado: Proceso =
    {
      procesoXEjecucionConsecutivo: 0,
      numeroProcesoEjecutado: 0,
      procesoConsecutivo: 0,
      nombreProceso: "",
      nombreSubproceso: "",
      fechaInicio: new Date(),
      EstadoProcesosSubprocesosEnum: Estados['NO_EJECUTADO']
    };

  // Hace referencia a la URL de la API que se va a consumir
  private readonly API_SERVER = 'any';


  // constructor 
  constructor(private http: HttpClient) { }


  // obtiene item seleccionado 
  getItemSeleccionado(): string {
    return this.itemSeleccionado;
  }

  // establece item seleccionado 
  setItemSeleccionado(opcion: string): void {
    this.itemSeleccionado = opcion;
  }

  // obtiene el objeto seleccionado
  getProcesoSeleccionado(): Proceso {
    return this.procesoSeleccionado;
  }
  
  // establece el objeto seleccionado
  setProcesoSeleccionado(proceso: Proceso): void {
    this.procesoSeleccionado = proceso;
  }

  // hace una peticion HTTP get a los subprocesos de un determinado proceso
  public obtenerSubprocesos(procesoXEjecucionConsecutivo: number): Observable<SubProceso> {
    return this.http.
      get<SubProceso>(`${this.API_SERVER}/${procesoXEjecucionConsecutivo}/subprocesos`);
  }

  // hace una peticion HTTP get a los errores de un determinado proceso
  public obtenerErrores(procesoXEjecucionConsecutivo: number): Observable<Informativa> {
    return this.http.
      get<Informativa>(`${this.API_SERVER}/${procesoXEjecucionConsecutivo}/errores`);
  }

  // hace una peticion HTTP get a los logs de un determinado proceso
  public obtenerLogs(procesoXEjecucionConsecutivo: number): Observable<Informativa> {
    return this.http.
      get<Informativa>(`${this.API_SERVER}/${procesoXEjecucionConsecutivo}/logs`);
  }


  /*
  get HTTP a archivos de pruebas. 
  */
  getProcesos(): Observable<Proceso[]> {
    return this.http.
      get<Proceso[]>('assets/procesos.json');
  }


  getSubProcesos(): Observable<SubProceso[]> {
    return this.http.
      get<SubProceso[]>('assets/subprocesos.json');
  }

  getErrores(): Observable<Informativa[]> {
    return this.http.
      get<Informativa[]>('assets/errores.json');
  }


  getLogs(): Observable<Informativa[]> {
    return this.http.
      get<Informativa[]>('assets/logs.json');
  }


}
