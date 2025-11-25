import { Component } from '@angular/core';
import { ArticuloModel } from '../model/ArticuloModel';



@Component({
  selector: 'app-articulo',
  imports: [],
  templateUrl: './articulo.html',
  styleUrl: './articulo.css',
})
export class Articulo {

  articulos: ArticuloModel[] = [
    {
      nombre: "Libro",
      precio: 10,
      unidades: 3
    }, {
      nombre: "Juguete",
      precio: 8,
      unidades: 8
    }, {
      nombre: "Lapiz",
      precio: 5,
      unidades: 6
    }
  ]

}
