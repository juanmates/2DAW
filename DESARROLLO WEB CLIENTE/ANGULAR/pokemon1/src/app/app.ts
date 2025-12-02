import { AsyncPipe } from '@angular/common';
import { PokemonService } from './services/pokemon-service';
import { Component, OnInit, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Observable } from 'rxjs';


@Component({
  selector: 'app-root',
  imports: [RouterOutlet, AsyncPipe],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App implements OnInit{

  pokemonList$ = new Observable<any>();

  constructor(private servicio:PokemonService){}

  ngOnInit(): void {
    this.pokemonList$ = this.servicio.getPokemon();
  }

  protected readonly title = signal('pokemon1');
  
}
