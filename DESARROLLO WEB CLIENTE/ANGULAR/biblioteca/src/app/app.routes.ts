import { Routes } from '@angular/router';
import { HomeComponent } from './home-component/home-component';
import { Libros } from './libros/libros';
import { LibroDetalle } from './libro-detalle/libro-detalle';
import { LibroNuevo } from './libro-nuevo/libro-nuevo';
import { LibroModificacion } from './libro-modificacion/libro-modificacion';

export const routes: Routes = [
  {path: "home", component: HomeComponent},
  {path: "", component: HomeComponent},
  {path: "libros", component: Libros},
  {path: "libroDetalle/:id", component: LibroDetalle},
  {path: "libroNuevo", component: LibroNuevo},
  {path: "libroModificar/:id", component: LibroModificacion}
];
