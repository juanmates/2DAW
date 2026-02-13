import { Component } from '@angular/core';

@Component({
  selector: 'app-footer',
  imports: [],
  templateUrl: './footer.html',
  styleUrl: './footer.css',
})
export class Footer {

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
