import { Component } from '@angular/core';

@Component({
  selector: 'app-user-profile',
  imports: [],
  templateUrl: './user-profile.html',
  styleUrl: './user-profile.css',
})
export class UserProfile {

  nombre: string = "Jessica";

  rol: string = "Streaper";

  titulo: string = "Este es el título";

  imagen: string = "/lopera.jpg";

  xxx: string = "Juan";

  naranja: string = "naranja"

  marcado: Boolean = true;

  asignatura = {
    nombre: 'cliente',
    codigo: 'CLT'
  };

}
