import { Component } from '@angular/core';

@Component({
  selector: 'app-alumno',
  imports: [],
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

}
