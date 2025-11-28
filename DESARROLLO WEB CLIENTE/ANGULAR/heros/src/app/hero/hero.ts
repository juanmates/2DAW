import { Component } from '@angular/core';

@Component({
  selector: 'app-hero',
  imports: [],
  templateUrl: './hero.html',
  styleUrl: './hero.css',
})
export class Hero {

  nombre:string = "ironman";
  edad:number = 24;
  nombreMayus: string = this.nombre.toUpperCase();
  total: string = this.nombre + ' ' + this.edad;

}
