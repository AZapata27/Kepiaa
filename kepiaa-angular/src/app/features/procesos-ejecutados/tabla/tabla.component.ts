import { Component, Input, OnInit } from '@angular/core';
import { Proceso } from 'src/app/core/models/proceso.interface';
import { Estados } from '../../../core/enums/estado.enum';
import { ProcesosServices } from '../../../core/services/procesos.service';
import { Observable } from 'rxjs';


@Component({
  selector: 'app-tabulacion',
  templateUrl: './tabla.component.html',
  styleUrls: ['./tabla.component.css']
})
export class tablaComponent implements OnInit {

  procesos: Object[] = [];
  procesoSeleccionado
    : Proceso =
    {
      procesoXEjecucionConsecutivo: 0,
      numeroProcesoEjecutado: 0,
      procesoConsecutivo: 0,
      nombreProceso: "",
      nombreSubproceso: "",
      fechaInicio: new Date(),
      EstadoProcesosSubprocesosEnum: Estados['NO_EJECUTADO']
    }


  constructor(private procesoService: ProcesosServices) { }


  ngOnInit(): void {

    this.procesoService.getProcesos().subscribe((procesos: Proceso[]) => {
      this.procesos = procesos;
    }
    )

  }

  first = 0;
  rows = 10;


  seleccionarFila() {
    this.procesoService.setProcesoSeleccionado(this.procesoSeleccionado);
  }

  deseleccionarFila() {
    this.procesoSeleccionado =
    {
      procesoXEjecucionConsecutivo: 0,
      numeroProcesoEjecutado: 0,
      procesoConsecutivo: 0,
      nombreProceso: "",
      nombreSubproceso: "",
      fechaInicio: new Date(),
      EstadoProcesosSubprocesosEnum: Estados['NO_EJECUTADO']
    }
    this.procesoService.setProcesoSeleccionado(this.procesoSeleccionado);
  }

}
