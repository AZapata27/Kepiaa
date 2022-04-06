import { Component, Input, OnInit } from '@angular/core';
import { Proceso } from 'src/app/core/models/proceso.interface';
import {MenuItem} from 'primeng/api';
import { DialogListDemo } from './dialogListDemo';
import { DialogService } from 'primeng/dynamicdialog';
import { MessageService } from 'primeng/api';
import { DynamicDialogRef } from 'primeng/dynamicdialog';
import { ProcesosServices } from 'src/app/core/services/procesos.service';
import { Estados } from '../../../core/enums/estado.enum';



@Component({
  selector: 'app-procesos',
  templateUrl: './informacion.component.html',
  styleUrls: ['./informacion.component.css'],
  providers: [DialogService, MessageService],
}) 
export class InformacionComponent  { 
  
   items: MenuItem[];
 

  constructor(
    public dialogService: DialogService,
    public messageService: MessageService, private procesoService: ProcesosServices )
  {
    this.items = [
      {label:'Resultado Ejecucion de procesos'},
      {label:'Subprocesos'},
  ];
  }
  ref: DynamicDialogRef = new DynamicDialogRef();

  first = 0;

  rows = 10;


 muestraDialog(opcion: string )
  {
   
    if(this.verificarFilaSeleccionada())
    {
      switch(opcion)
      {
        case "subproceso":
        
          this.procesoService.setItemSeleccionado(opcion); 
          this.desplegarDialog("SubProcesos");   
          break; 
  
          case "error": 
          this.procesoService.setItemSeleccionado(opcion); 
          this.desplegarDialog("Errores del proceso"); 
          break; 
  
          case "log": 
          this.procesoService.setItemSeleccionado(opcion); 
          this.desplegarDialog("Logs del Proceso"); 
          break; 
      }
    } else{
      this.messageService.add({severity:'warn', summary:'Opcion Invalida' , detail:'Primero seleccione un proceso en la tabla.'});
    }

  }


  verificarFilaSeleccionada(): boolean
  {
   
    if(this.procesoService.getProcesoSeleccionado().procesoXEjecucionConsecutivo != 0)
    {
      return true;
    } else{
      return false; 
    }
  }


  desplegarDialog(tituloDialog: string)
  {
    this.ref = this.dialogService.open(DialogListDemo, {
      header: tituloDialog,
      width: '70%',
      contentStyle: { 'max-height': '500px', overflow: 'auto' },
      baseZIndex: 10000
    });
  }



}


 
