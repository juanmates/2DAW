import { Component, OnInit } from '@angular/core';
import { LibrosService } from '../services/libros-service';
import { LibroModel } from '../model/libroModel';
import { ActivatedRoute, RouterLink } from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-libro-modificacion',
  imports: [FormsModule, RouterLink],
  templateUrl: './libro-modificacion.html',
  styleUrl: './libro-modificacion.css',
})
export class LibroModificacion implements OnInit{

  libro: LibroModel = {
    id: 0,
    titulo: "",
    autor: ""
  }

  id_libro: number = 0;

  constructor(private servicio: LibrosService, private ruta: ActivatedRoute) {}

  ngOnInit(): void {
    this.id_libro = this.ruta.snapshot.params['id'];
    this.libro = this.servicio.getLibro(this.id_libro);
  }

  modificarLibro(){
    this.servicio.actualizarLibro(this.libro);
  }
}
