import { Routes } from '@angular/router';
import { UsuarioComponent } from './usuario/usuario.component';
import { PostComponent } from './post/post.component';

export const routes: Routes = [
  {path: "usuario", component:UsuarioComponent },
  {path: "post", component:PostComponent }
];
