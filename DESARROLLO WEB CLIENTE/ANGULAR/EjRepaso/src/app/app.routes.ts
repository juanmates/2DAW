import { Routes } from '@angular/router';
import { Usuario } from './usuario/usuario';
import { Posts } from './posts/posts';

export const routes: Routes = [
  { path: "usuario", component: Usuario},
  { path: "posts", component: Posts}
];
