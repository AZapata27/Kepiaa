// Modulos 

// Centrales 
import { NgModule } from '@angular/core';

// PrimeNg
import {ButtonModule} from 'primeng/button';
import {TableModule} from 'primeng/table';
import {ToastModule} from 'primeng/toast';
import {DropdownModule} from 'primeng/dropdown';
import {CalendarModule} from 'primeng/calendar';
import {InputTextModule} from 'primeng/inputtext';
import {BreadcrumbModule} from 'primeng/breadcrumb';
import {DynamicDialogModule} from 'primeng/dynamicdialog';
import { PanelMenuModule } from 'primeng/panelmenu';

@NgModule({
  declarations: [],
  imports: [
    DropdownModule,
    InputTextModule,
    CalendarModule, 
    ButtonModule,
    TableModule,
    ToastModule,
    BreadcrumbModule,
    DynamicDialogModule,
    ToastModule, 
    PanelMenuModule
  ], 
  exports: [
    DropdownModule,
    InputTextModule,
    CalendarModule, 
    ButtonModule,
    TableModule,
    ToastModule,
    BreadcrumbModule,
    DynamicDialogModule,
    ToastModule,
    PanelMenuModule
  ]

})
export class SharedPrimeNgModule { }
