import { Injectable } from '@angular/core';
import { Personaje } from '../model/Personaje';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})

export class Anillos {

   personajes: Personaje[] = [

    {
      id: 1,
      nombre: "Juan",
      raza: "perro"
    },
    {
      id: 2,
      nombre: "Pepe",
      raza: "gato"
    },
    {
      id: 3,
      nombre: "Lola",
      raza: "perro"
    }
   ]

   getPersonajes() {
    return this.personajes;
   }

   borrarPersonaje(idAborrar:number){
    this.personajes.splice(idAborrar, 1)
    return this.personajes;
   }



}
