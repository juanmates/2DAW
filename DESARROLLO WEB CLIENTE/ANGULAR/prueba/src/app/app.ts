import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { UserProfile } from './user-profile/user-profile';
import { Alumno } from "./alumno/alumno";
import { DatosLibro } from "./datos-libro/datos-libro";

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, UserProfile, Alumno, DatosLibro],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  title = 'angular';
  nombre : string = "Juan";
  edad: number = 18;

  // Metodo que devuelve el valor edad
  getEdad() : number {
    return this.edad;
  }

  esMayor() : string {
    if(this.edad >= 18){
      return 'mayor de edad';
    } else {
      return 'menor de edad';
    }
  }

}
