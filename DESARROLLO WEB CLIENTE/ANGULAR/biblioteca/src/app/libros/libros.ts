import { Component, OnInit } from '@angular/core';
import { LibroModel } from '../model/libroModel';
import { LibrosService } from '../services/libros-service';
import { CommonModule } from '@angular/common';
import { RouterLink } from "@angular/router";

@Component({
  selector: 'app-libros',
  imports: [CommonModule, RouterLink],
  templateUrl: './libros.html',
  styleUrl: './libros.css',
})
export class Libros implements OnInit{

  libros: LibroModel[] = [];

  constructor(private servicio: LibrosService){}
  ngOnInit(): void {
    this.getLibros()
  }


  getLibros(){
    this.libros = this.servicio.getLibros();
  }

}
