import { Component } from '@angular/core';

@Component({
  selector: 'app-list',
  imports: [],
  templateUrl: './list.html',
  styleUrl: './list.css',
})
export class List {
  heroes: string[] = ['Spiderman', 'Ironman', 'Hulk', 'Thor'];
  heroeBorrado?: string;

    borrarUltimoHeroe(): void {
    if (this.heroes.length === 0) {
      this.heroeBorrado = undefined;
      return;
    }
    const ultimoIndex = this.heroes.length - 1;
    this.heroeBorrado = this.heroes[ultimoIndex]; // guardar el eliminado
    this.heroes = this.heroes.filter((_, index) => index !== ultimoIndex); // eliminarlo sin pop
  }
}
