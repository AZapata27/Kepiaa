import { Component } from '@angular/core';
import { MenuItem } from 'primeng/api/menuitem';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'kepiaa';

  items: MenuItem[] = [];

  ngOnInit() {
      this.items = [
    
         {
            "label":"Inicio",
            "icon":"none",
            "routerLink":"/sidetcorp-menu-view/index.html#/sidetcorp-menu-view/inicioComponent",
            "items":[]
         },
         {
            "label":"Código de Barras",
            "icon":"none",
            "routerLink":null,
            "items":[
               {
                  "label":"Configurar Parámetros",
                  "icon":"none",
                  "routerLink":"/sidetcorp-codbar-view/index.html#/sidetcorp-codbar-view/Configurarparametros",
                  "items":[]
               },
               {
                  "label":"Generar e Imprimir Códigos de Barras",
                  "icon":"none",
                  "routerLink":"/sidetcorp-codbar-view/index.html#/sidetcorp-codbar-view/GenerarImprimirCodBar",
                  "items":[]
               },
               {
                  "label":"Reimprimir Códigos de Barras",
                  "icon":"none",
                  "routerLink":"/sidetcorp-codbar-view/index.html#/sidetcorp-codbar-view/ReimprimirCodBar",
                  "items":[]
               },
               {
                  "label":"Imprimir Códigos de Barras Especiales",
                  "icon":"none",
                  "routerLink":"/sidetcorp-codbar-view/index.html#/sidetcorp-codbar-view/ImprimirCodBarEspeciales",
                  "items":[]
               }
            ]
         },
         {
            "label":"Especies en Consulta",
            "icon":"none",
            "routerLink":null,
            "items":[
               {
                  "label":"Registrar Solicitud",
                  "icon":"none",
                  "routerLink":"/sidetcorp-especies-view/index.html#/sidetcorp-especies-view/crearSolicitud",
                  "items":[]
               },
               {
                  "label":"Consultar Solicitudes",
                  "icon":"none",
                  "routerLink":"/sidetcorp-especies-view/index.html#/sidetcorp-especies-view/consultaGenericaSolicitud",
                  "items":[]
               },
               {
                  "label":"Realizar Remisión",
                  "icon":"none",
                  "routerLink":"/sidetcorp-especies-view/index.html#/sidetcorp-especies-view/remitirEspecieMonetaria",
                  "items":[]
               },
               {
                  "label":"Gestionar Remisión",
                  "icon":"none",
                  "routerLink":"/sidetcorp-especies-view/index.html#/sidetcorp-especies-view/gestionarRemision",
                  "items":[]
               },
               {
                  "label":"Recibir Remisión",
                  "icon":"none",
                  "routerLink":"/sidetcorp-especies-view/index.html#/sidetcorp-especies-view/recibirRemision",
                  "items":[]
               },
               {
                  "label":"Notificar Master",
                  "icon":"none",
                  "routerLink":"/sidetcorp-especies-view/index.html#/sidetcorp-especies-view/notificarMasterSidet",
                  "items":[]
               }
            ]
         },
         {
            "label":"Cambios en Ventanilla",
            "icon":"none",
            "routerLink":null,
            "items":[
               {
                  "label":"Registrar Cambios",
                  "icon":"none",
                  "routerLink":"/sidetcorp-ov-view/index.html#/sidetcorp-ov-view/CambiosEfectivo",
                  "items":[]
               },
               {
                  "label":"Consulta Operaciones",
                  "icon":"none",
                  "routerLink":"/sidetcorp-ov-view/index.html#/sidetcorp-ov-view/ConsultaOperaciones",
                  "items":[]
               },
               {
                  "label":"Reporte Tirillas",
                  "icon":"none",
                  "routerLink":"/sidetcorp-ov-view/index.html#/sidetcorp-ov-view/ConsultaTirillaOperacion",
                  "items":[]
               },
               {
                  "label":"Ver Transacciones a Reportar",
                  "icon":"none",
                  "routerLink":"/sidetcorp-ov-view/index.html#/sidetcorp-ov-view/ConsultaOperacionReportar",
                  "items":[]
               },
               {
                  "label":"Generar Reporte Excel",
                  "icon":"none",
                  "routerLink":"/sidetcorp-ov-view/index.html#/sidetcorp-ov-view/ReporteDetalleOperacion",
                  "items":[]
               }
            ]
         },
         {
            "label":"Administración",
            "icon":"none",
            "routerLink":null,
            "items":[
               {
                  "label":"Chequeo Diario",
                  "icon":"none",
                  "routerLink":"/sidetcorp-menu-view/index.html#/sidetcorp-menu-view/chequeoDiario",
                  "items":[]
               }
            ]
         }




      ]


   }
} 
