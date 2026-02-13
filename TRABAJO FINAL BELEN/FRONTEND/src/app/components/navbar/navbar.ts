import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-navbar',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './navbar.html',
  styleUrls: ['./navbar.css']
})
export class NavbarComponent {

  scrollTo(id: string) {
    const element = document.getElementById(id);
    if (element) {
      element.scrollIntoView({ behavior: 'smooth', block: 'start' });
    }
  }


  irAlBuscador() {
    this.scrollTo('buscador-seccion');


    setTimeout(() => {
      const input = document.getElementById('input-busqueda') as HTMLInputElement;
      if (input) input.focus();
    }, 600);
  }
}
