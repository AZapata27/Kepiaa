import { Component, ElementRef, OnInit, ViewChild, Renderer2 } from '@angular/core';
import { Indice } from '../../../core/models/indice';
import { Estados } from '../../../core/enums/estado.enum';


@Component({
  selector: 'app-busqueda',
  templateUrl: './busqueda.component.html',
  styleUrls: ['./busqueda.component.css']
})
export class BusquedaComponent implements OnInit {


  indices: Indice[];
  selectedIndice: Indice = { name: "", code : "" }
  estados: Indice[] = [];

  busquedaSimple: boolean = false;
  busquedaAvanzada: boolean = true;
  date3: Date = new Date();
  txtBuscar: boolean = true;


  ngOnInit(): void {

  }

  constructor(private render: Renderer2) {


    this.indices = [
      {
        name: "Numero de Proceso Ejecutado",
        code: "1"
      },
      {
        name: "Nombre Proceso",
        code: "2"
      },
      {
        name: "Nombre Sub-Proceso",
        code: "3"
      },
      {
        name: "Fecha de inicio",
        code: "4"
      },
      {
        name: "Estado",
        code: "5"
      }
    ]

    this.llenarItems();
  }


  llenarItems(): void {
    let i = 0;

    for (let item in Estados) {
      i++;
      this.estados.push(
        {
          name: item.toString(),
          code: i.toString()
        }
      );
    }
  }



  cambiarBusqueda(busqueda: string) {
    if (busqueda === 'simple') {
      console.log("se está ejecutando simple")
      this.busquedaSimple = false;
      this.busquedaAvanzada = true;
    } else {
      console.log("se está ejecutando avanzada")
      this.busquedaSimple = true;
      this.busquedaAvanzada = false;
    }
  }

  cambiarCampoDeBusqueda(): void {
     if(this.selectedIndice.code === '4')
     {
       this.txtBuscar = false;
     } else{
      this.txtBuscar = true; 
     }
  };






}
