// Modulos 


// Centrales 

import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {HttpClientModule } from '@angular/common/http';

// Compartidos 

import { SharedPrimeNgModule } from 'src/app/shared/SharedPrimeNg.module';

// De funciones 

import { tablaComponent } from './tabla/tabla.component';
import { BusquedaComponent } from './busqueda/busqueda.component';
import { InformacionComponent } from './informacion/informacion.component';
import { DialogListDemo } from './informacion/dialogListDemo';
import { SpinnerModulo } from 'src/app/shared/components/spinner/spinner.module';



@NgModule({
    declarations: [
      BusquedaComponent,
      tablaComponent,
      InformacionComponent,
      DialogListDemo
  
    ],
    imports: [
      CommonModule,
      BrowserAnimationsModule, 
      SharedPrimeNgModule,
      FormsModule,
      RouterModule,
      HttpClientModule,
      SpinnerModulo
    ], 
    exports:
    [ 
     
    ]
  ,
  providers:
  [       ],
  bootstrap:    [  ]
  })
  export class ProcesosEjecutadosModule{ }
  