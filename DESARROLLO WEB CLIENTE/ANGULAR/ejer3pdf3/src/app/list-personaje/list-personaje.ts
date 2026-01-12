import { Observable, of } from 'rxjs';
import { Component, OnInit } from '@angular/core';
import { Anillos } from '../services/anillos';
import { Personaje } from '../model/Personaje';
import { AsyncPipe, CommonModule } from '@angular/common';

@Component({
  selector: 'app-list-personaje',
  standalone: true,
  imports: [AsyncPipe, CommonModule],
  templateUrl: './list-personaje.html',
  styleUrl: './list-personaje.css',
})
export class ListPersonaje implements OnInit{

  personajes!: Observable<Personaje[]>;

  constructor(private servicio: Anillos) {}

  ngOnInit(): void {
    this.personajes = of(this.servicio.getPersonajes());
  }

  borrarPersonaje(id:number) {
    return this.servicio.borrarPersonaje(id);
  }

}
