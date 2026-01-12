import { Component } from '@angular/core';
import { ListPersonaje } from '../list-personaje/list-personaje';
import { AddPersonaje } from "../add-personaje/add-personaje";

@Component({
  selector: 'app-main',
  standalone: true,
  imports: [ListPersonaje, AddPersonaje],
  templateUrl: './main.html',
  styleUrl: './main.css',
})
export class Main {

}
