import { Tabla } from './tabla/tabla';
import { Aleatorio } from './aleatorio/aleatorio';
import { Routes } from '@angular/router';

export const routes: Routes = [
  {path: "aleatorio", component: Aleatorio},
  {path: "tabla", component: Tabla}
];
