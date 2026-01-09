import { Routes } from '@angular/router';
import { UsuarioComponent } from './usuario/usuario';
import { PostComponent } from './post/post';

export const routes: Routes = [
  { path: 'usuario', component: UsuarioComponent },
  { path: 'posts', component: PostComponent },
];
