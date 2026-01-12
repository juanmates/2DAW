import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';


@Component({
  selector: 'app-add-personaje',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './add-personaje.html',
  styleUrl: './add-personaje.css',
})
export class AddPersonaje {

  nombreNuevo: string = "";
  raza: string = "";

}
