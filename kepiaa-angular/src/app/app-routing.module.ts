import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { InformacionComponent } from "./features/procesos-ejecutados/informacion/informacion.component";
import { tablaComponent } from "./features/procesos-ejecutados/tabla/tabla.component";

const routes: Routes = [
   { path: 'procesos-ejecutados/sub-procesos', component: InformacionComponent },
    { path: '', component: tablaComponent } ,
    { path: 'procesos-ejecutados' , component: tablaComponent}
]; 

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule{}