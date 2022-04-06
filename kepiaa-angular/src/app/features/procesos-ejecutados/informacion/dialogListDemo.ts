import { Component, OnInit } from '@angular/core';

import {DynamicDialogRef} from 'primeng/dynamicdialog';
import {DynamicDialogConfig} from 'primeng/dynamicdialog';
import { ProcesosServices } from 'src/app/core/services/procesos.service';
import { SubProceso } from 'src/app/core/models/subproceso.interface';
import { Informativa } from 'src/app/core/models/informativa.interface';


@Component({
    template: `
   <div class="tabulacion">
  <div class="card">      
      <p-table [value]="procesos" sortMode="multiple" [paginator]="true" [rows]="10" [showCurrentPageReport]="true" selectionMode="single"   responsiveLayout="scroll"
      [scrollable]="true" scrollHeight="400px"  currentPageReportTemplate="Mostrando {first} a {last} de {totalRecords} registros" [rowsPerPageOptions]="[10]">
          <ng-template pTemplate="header">
              <tr>
                  <th pSortableColumn="{{indice[0]}}"> {{indice[0]}} <p-sortIcon field="code"></p-sortIcon></th>
                  <th pSortableColumn="{{indice[1]}}"> {{indice[1]}}  <p-sortIcon field="name"></p-sortIcon></th>
                 
              </tr>
          </ng-template>
          <ng-template pTemplate="body" let-proceso>
              <tr>
                  
              <td *ngIf="proceso.nombre != undefined else fecha " > {{ proceso.nombre }} </td>
    
                <ng-template #fecha>
                  <td>{{ proceso.fecha }}</td>
              </ng-template>
           
              <td>{{  proceso.mensaje }}</td>
              </tr>
          </ng-template>
      </p-table>
  </div>
</div>
    `
})
export class DialogListDemo implements OnInit {

    procesos : Object[] = [];
    
    indice : string [] = [];

            
    constructor(public procesosServices: ProcesosServices, public ref: DynamicDialogRef, public config: DynamicDialogConfig) { }

     

    ngOnInit() {
      
        
        switch(this.procesosServices.getItemSeleccionado())
        {
            case "subproceso":
                
                this.procesosServices.getSubProcesos().subscribe(  ( subprocesos : SubProceso[])  => 
                {
                   this.procesos =  subprocesos;
                   this.cargarIndice(this.procesos[0])
                }); 
           

            break; 

            case  "error" :
                this.procesosServices.getErrores().subscribe(  ( errores : Informativa[])  =>
                {
                    this.procesos = errores; 
                    this.cargarIndice(this.procesos[0])
                } );
            break; 

            case "log": 
                this.procesosServices.getLogs().subscribe( ( logs : Informativa[])  => {
            
                    this.procesos = logs; 
                    this.cargarIndice(this.procesos[0])
                    
                }) ;
            break; 
        }
       

    }


    cargarIndice(process : Object)
    {

        for (const [ key ] of Object.entries(process)) {
           this.indice.push(key.toLocaleUpperCase());
         }

    }

    
}