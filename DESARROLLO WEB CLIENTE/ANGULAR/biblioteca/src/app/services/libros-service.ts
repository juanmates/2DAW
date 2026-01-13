import { Injectable } from '@angular/core';
import { LibroModel } from '../model/libroModel';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class LibrosService {

  libros: LibroModel[] = [
    {
      id: 1,
      titulo: "titulo1",
      autor: "autor1"
    },
    {
      id: 2,
      titulo: "titulo2",
      autor: "autor2"
    },
    {
      id: 3,
      titulo: "titulo3",
      autor: "autor3"
    },
    {
      id: 4,
      titulo: "titulo4",
      autor: "autor4"
    }
  ]

  constructor(private http: HttpClient){}

  getLibros(): LibroModel[] {
    return this.libros;
  }

  anadirLibro(LibroNuevo:LibroModel){
    this.libros.push(LibroNuevo);
  }

  actualizarLibro(LibroNuevo:LibroModel) {
    const libro: LibroModel = this.libros[LibroNuevo.id-1];
    libro.titulo = LibroNuevo.titulo;
    libro.autor = LibroNuevo.autor;
  }

  getLibro(id:number) {
    return this.libros[id-1];
  }

}
