// Modulos

// Centrales 
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';
import { AppRoutingModule } from './app-routing.module';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';

// Compartidos 
import { SharedPrimeNgModule } from './shared/SharedPrimeNg.module';

// De funciones 
import { AppComponent } from './app.component';
import { ProcesosEjecutadosModule } from './features/procesos-ejecutados/procesosEjecutados.module';
import { SpinnerModulo } from './shared/components/spinner/spinner.module';
import { SpinnerInterceptor } from 'src/app/core/interceptors/spinner.interceptors';


@NgModule({ 
  declarations: [
    AppComponent
  ],

  imports: [
    BrowserModule, 
    RouterModule,
    SharedPrimeNgModule,
    AppRoutingModule,
    ProcesosEjecutadosModule, 
    HttpClientModule ,
    SpinnerModulo
  ],
  providers: [
    {provide: HTTP_INTERCEPTORS, useClass: SpinnerInterceptor, multi: true }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }