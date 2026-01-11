import { UsuarioModel } from './../model/usuario';
import { Component } from '@angular/core';
import { Observable } from 'rxjs';
import { UsuarioService } from '../services/usuario-service';
import { AsyncPipe } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-usuario',
  imports: [AsyncPipe, FormsModule],
  templateUrl: './usuario.html',
  styleUrl: './usuario.css',
})
export class Usuario {
  id:number = 0;
  usuario = new Observable<UsuarioModel>();

  constructor(private usuariosService: UsuarioService) {}

  getUsuario(): any {
    this.usuario = this.usuariosService.getUsuario(this.id);
  }
}
