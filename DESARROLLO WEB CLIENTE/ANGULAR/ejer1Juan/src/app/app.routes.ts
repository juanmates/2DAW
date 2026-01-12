import { Routes } from '@angular/router';
import { Usuario } from './usuario/usuario';
import { Post } from './post/post';

export const routes: Routes = [
  {path: "usuario", component: Usuario},
  {path: "post", component: Post}
];
