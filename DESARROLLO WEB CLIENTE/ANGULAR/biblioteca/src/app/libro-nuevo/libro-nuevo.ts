import { LibroModel } from './../model/libroModel';
import { Component } from '@angular/core';
import { RouterLink } from "@angular/router";
import { LibrosService } from '../services/libros-service';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-libro-nuevo',
  imports: [RouterLink, FormsModule],
  templateUrl: './libro-nuevo.html',
  styleUrl: './libro-nuevo.css',
})
export class LibroNuevo {

  nombre:string = "";
  autor:string = "";

  constructor(private servicio: LibrosService){}

  getLibros() {
    return this.servicio.getLibros();
  }

  anadirLibroNuevo() {
    const libro:LibroModel = {
      id: this.getLibros().length + 1,
      titulo: this.nombre,
      autor: this.autor
    }
    this.servicio.anadirLibro(libro);
  }

}
