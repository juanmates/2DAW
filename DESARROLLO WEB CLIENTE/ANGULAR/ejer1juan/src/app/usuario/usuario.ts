import { Observable } from 'rxjs';
import { UsuarioServicio } from '../services/usuarioServicio';
import { Component } from '@angular/core';
import { UsuarioModel } from '../../model/UsuarioModel';
import { FormsModule } from '@angular/forms';
import { AsyncPipe, CommonModule } from '@angular/common';

@Component({
  selector: 'app-usuario',
  imports: [FormsModule, AsyncPipe, CommonModule],
  templateUrl: './usuario.html',
  styleUrl: './usuario.css',
})
export class Usuario {
  num: number = 0;
  usuario = new Observable<UsuarioModel>;
  constructor(private servicio: UsuarioServicio){}
  getUsuario() {
    this.usuario = this.servicio.getUsuario(this.num);
    console.log(this.usuario);
  }
}
