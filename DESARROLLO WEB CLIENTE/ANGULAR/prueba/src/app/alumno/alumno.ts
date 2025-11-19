import { Component } from '@angular/core';

import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-alumno',
  imports: [FormsModule],
  templateUrl: './alumno.html',
  styleUrl: './alumno.css',
})
export class Alumno {

  rojo: string = "rojo";

  nombre: string = "Juan";
  apellido: string = "Matés Castillo";
  edad: number = 23;
  dni: string = "77926201Q";

  edad5() {
    return this.edad*5;
  }

  mayorDeEdad() {
    if(this.edad >= 18) {
      return "es mayor de edad"
    } else {
      return "es menor de edad"
    }
  }

  miTexto:string = "";
  mostrarTexto(evento:any) {
    this.miTexto = evento.target.value;
  }
  alerta(evento:any) {
    alert("Has pinchado en el checkbox");
  }

  texto: string = "";
  texto1: string = "";
  texto2: string = "";

  check: string = "fondo";

  marcado(event:any) {
    return;
  }

  valor:string = "https://www.ceuandalucia.es";

 mostrarCapa: boolean = true;

 cambiarValor() {
    this.mostrarCapa = !this.mostrarCapa;
 }

 botonHAB: boolean = true;

 boton() {
  this.botonHAB = !this.botonHAB;
 }

}
