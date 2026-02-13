import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { NavbarComponent } from "./components/navbar/navbar";
import { Hero } from "./components/hero/hero";
import { SearchBar } from "./components/search-bar/search-bar";
import { AutoescuelaListComponent } from "./components/autoescuela-list/autoescuela-list.component";
import { Footer } from "./components/footer/footer";

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, NavbarComponent, Hero, SearchBar, AutoescuelaListComponent, Footer],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('LETSDRIVE');
}
