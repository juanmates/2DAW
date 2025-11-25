import { CommonModule, NgIf } from '@angular/common';
import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { FormsModule } from '@angular/forms';

export interface Persona {
  nombre: string;
  apellidos: string;
  edad: number;
}


@Component({
  selector: 'app-root, app-articulo',
  imports: [RouterOutlet, CommonModule, FormsModule, NgIf],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {

  nombre: string = "";

  apellidos:string = "";

  mensaje: string = "";

  mostrarTexto(){
   // this.nombre = evento.target.value;
   // this.apellidos = evento.target.value;
    this.mensaje = `Alta correcta del usuario ${this.nombre} ${this.apellidos}`;
  }

  personas: Persona[] = [
    {
      nombre: "Pepe",
      apellidos: "Lopez",
      edad: 35
    },
    {
      nombre: "Rosa",
      apellidos: "Torres",
      edad: 16
    }
  ]

   respuesta: string = "";

  marcar(evento:any){
    if(evento.target.value == "A"){
      this.respuesta =  "Se ha pulsado el boton A";
    } else if (evento.target.value == "B"){
      this.respuesta =  "Se ha pulsado el boton B";
    } else if (evento.target.value == "C"){
      this.respuesta =  "Se ha pulsado el boton C";
    }
    else {
      this.respuesta = "No se ha pulsado ningún boton";
    }
  }


}
