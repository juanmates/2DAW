import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { MensajeHijo } from './mensaje-hijo/mensaje-hijo';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, MensajeHijo, FormsModule],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  title = "Mensaje Padre";

  texto:string="";


  miMensajeHijo:string="";

  mostrarMensajeHijo(MensajeHijo:string) {
    this.miMensajeHijo = MensajeHijo;

  }

}
