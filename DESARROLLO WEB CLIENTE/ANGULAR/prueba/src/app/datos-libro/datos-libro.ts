import { Component, EventEmitter, Input, Output} from '@angular/core';

@Component({
  selector: 'app-datos-libro',
  imports: [],
  templateUrl: './datos-libro.html',
  styleUrl: './datos-libro.css',
})
export class DatosLibro {

  titulo: string = "Datos del componente Libro";

  libro = {
    titulo: "Titulo del libro",
    autor: "Autor del libro",
    precio: 10,
    stock: 7,
    cantidad: 3,
    imagen: '/lopera.jpg'
  }

  coords(evento:any){
    console.log(evento.clientX, evento.clientY);
  }

  libro2 = {
    titulo: "Titulo del libro 2",
    autor: "Autor del libro 2",
    precio: 5,
    stock: 2,
    cantidad: 1,
    imagen: '/lopera.jpg'
  }

  libros:any[] = [this.libro, this.libro2];

  @Input()
  num:string = "";

  @Output()
    selected = new EventEmitter<any>();



}
