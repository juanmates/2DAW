import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Counter } from './counter/counter';
import { Hero } from "./hero/hero";
import { List } from "./list/list";

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, Counter, Hero, List],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
}
