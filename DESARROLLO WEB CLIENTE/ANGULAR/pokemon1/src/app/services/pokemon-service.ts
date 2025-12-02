import { HttpClient } from '@angular/common/http';
import { Injectable} from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class PokemonService{

  // URL de la API
  url:string = "https://pokeapi.co/api/v2/pokemon?offset=10&limit=20";

  // Constructor
  constructor(private http:HttpClient){}

  getPokemon():any {
    return this.http.get(this.url);
  }
  
}
