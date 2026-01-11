import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Superheroes } from './superheroes/superheroes';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet,Superheroes],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  
}
