import { Estados } from '../../core/enums/estado.enum';
export interface Proceso {
    procesoXEjecucionConsecutivo: number;
    numeroProcesoEjecutado: number;
    procesoConsecutivo: number;
    nombreProceso: string;
    nombreSubproceso: string;
    fechaInicio: Date;
    EstadoProcesosSubprocesosEnum: Estados
}