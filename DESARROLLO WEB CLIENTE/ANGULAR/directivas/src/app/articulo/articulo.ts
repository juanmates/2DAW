import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { ListadoArticulo } from '../listado-articulo/listado-articulo';
import { ArticuloModel } from '../model/ArticuloModel';

@Component({
  selector: 'app-articulo',
  imports: [FormsModule, CommonModule, ListadoArticulo],
  templateUrl: './articulo.html',
  styleUrls: ['./articulo.css'],
})
export class Articulo {
  nombre: string = '';
  precio: number = 0;
  unidades: number = 0;

  articulos: ArticuloModel[] = [];

  comprar() {
    if(this.nombre && this.precio > 0 && this.unidades > 0) {
      this.articulos.push({
        nombre: this.nombre,
        precio: this.precio,
        unidades: this.unidades
      });
      this.nombre = '';
      this.precio = 0;
      this.unidades = 0;
    }
  }
}
