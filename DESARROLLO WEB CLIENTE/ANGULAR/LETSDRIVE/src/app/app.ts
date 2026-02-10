import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { NavbarComponent } from "./components/navbar/navbar";
import { Hero } from "./components/hero/hero";
import { SearchBar } from "./components/search-bar/search-bar";
import { AutoescuelaListComponent } from "./components/autoescuela-list/autoescuela-list.component";

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, NavbarComponent, Hero, SearchBar, AutoescuelaListComponent],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('LETSDRIVE');
}
