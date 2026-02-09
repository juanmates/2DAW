import { Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { ListaAutoescuelasComponent } from './components/lista-autoescuelas/lista-autoescuelas';

export const routes: Routes = [
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  { path: 'login', component: LoginComponent },
  { path: 'autoescuelas', component: ListaAutoescuelasComponent }
];
