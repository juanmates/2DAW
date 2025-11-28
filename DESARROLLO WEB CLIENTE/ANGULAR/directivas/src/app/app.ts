import { CommonModule, NgIf } from '@angular/common';
import { Component, signal } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterOutlet } from '@angular/router';
import { Persona } from './model/Persona';
import { Articulo } from "./articulo/articulo";

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, CommonModule, FormsModule, NgIf, Articulo],
  templateUrl: './app.html',
  styleUrl: './app.css',
})
export class App {
  nombre: string = '';
  apellidos: string = '';
  parrafo: string = '';

  mostrarParrafo() {
    this.parrafo = `Alta correcta del usuario ${this.nombre} ${this.apellidos}`;
  }

  persona1 = {
    nombre: 'Juan',
    apellidos: 'Matés Castillo',
    edad: 30,
  };
  persona2 = {
    nombre: 'Joaquin',
    apellidos: 'Del Castillo',
    edad: 50,
  };

  personas: Persona[] = [this.persona1, this.persona2];

  mensajeBotones: string = 'No ha seleccionado ningún botón';

  tunearMensaje($event: any) {
    if ($event.target.value == 'A') {
      this.mensajeBotones = 'Pulsado el botón A';
    } else if ($event.target.value == 'B') {
      this.mensajeBotones = 'Pulsado el botón B';
    } else {
      this.mensajeBotones = 'Pulsado el botón C';
    }
  }
}
