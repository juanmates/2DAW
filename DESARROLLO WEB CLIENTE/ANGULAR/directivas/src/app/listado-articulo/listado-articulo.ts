import { Component, Input } from '@angular/core';
import { ArticuloModel } from '../model/ArticuloModel';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-listado-articulo',
  imports: [CommonModule],
  templateUrl: './listado-articulo.html',
  styleUrls: ['./listado-articulo.css']
})
export class ListadoArticulo {
  @Input() listaArticulos: ArticuloModel[] = [];
}
