import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Route, RouterLink } from '@angular/router';
import { LibroModel } from '../model/libroModel';
import { LibrosService } from '../services/libros-service';

@Component({
  selector: 'app-libro-detalle',
  imports: [RouterLink],
  templateUrl: './libro-detalle.html',
  styleUrl: './libro-detalle.css',
})
export class LibroDetalle implements OnInit{

  id: number = 0;
  ListaLibros: LibroModel[] = [];

  constructor(private ruta: ActivatedRoute, private  servicio: LibrosService){}


  ngOnInit(): void {
    this.id = this.ruta.snapshot.params["id"]
    this.ListaLibros = this.servicio.getLibros();
  }
}
