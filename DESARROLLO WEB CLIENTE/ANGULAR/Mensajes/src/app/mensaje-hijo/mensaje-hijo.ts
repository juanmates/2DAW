import { Component, EventEmitter, Input, Output } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-mensaje-hijo',
  imports: [FormsModule],
  templateUrl: './mensaje-hijo.html',
  styleUrl: './mensaje-hijo.css',
})
export class MensajeHijo {

  @Input()
  textoHijo:string="";

  mensajeHijo:string="";


  @Output()
  selected = new EventEmitter<string>();

  enviarMensaje() {
    this.selected.emit(this.mensajeHijo);
  }

}
