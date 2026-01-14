import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Anillos } from '../services/anillos';
import { Personaje } from '../model/Personaje';


@Component({
  selector: 'app-add-personaje',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './add-personaje.html',
  styleUrl: './add-personaje.css',
})
export class AddPersonaje {

  personajeNuevo: Personaje = {
    id: 0,
    nombre: "",
    raza: ""
  }

  constructor(private servicio: Anillos) {}

  agregarPersonaje():void{

    if(this.personajeNuevo.nombre && this.personajeNuevo.raza) {
      this.personajeNuevo.id = this.servicio.getPersonajes().length + 1;
      this.servicio.agregarPersonaje(this.personajeNuevo);
      this.personajeNuevo = {id: 0, nombre: "", raza: ""};
    }
  }
}
