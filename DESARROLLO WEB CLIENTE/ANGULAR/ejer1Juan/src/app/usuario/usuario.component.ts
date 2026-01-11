import { Observable } from 'rxjs';
import { UsuarioService } from '../services/usuario.service';
import { Component } from '@angular/core';
import { UsuarioModel } from '../model/Usuario';
import { FormsModule } from '@angular/forms';
import { AsyncPipe } from '@angular/common';

@Component({
  selector: 'app-usuario',
  standalone: true,
  imports: [FormsModule, AsyncPipe],
  templateUrl: './usuario.component.html',
  styleUrl: './usuario.component.css'
})
export class UsuarioComponent {

  mostrarDiv:boolean = false;

  id:number = 0;
  usuario!: Observable<UsuarioModel>;

  constructor(private servicio: UsuarioService) {}

  mostrarUsuario(): any {
    this.usuario = this.servicio.getUsuario(this.id);
  }

  cambiarDiv() {
    this.mostrarDiv = !this.mostrarDiv;
  }

}
