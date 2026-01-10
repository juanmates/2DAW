import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-usuario',
  imports: [FormsModule, CommonModule],
  templateUrl: './usuario.html'
})
export class UsuarioComponent {
  userId: string = '';
  user: any = null;

  constructor(private http: HttpClient) {}

  buscarUsuario() {
    this.http.get(`https://jsonplaceholder.typicode.com/users/${this.userId}`)
      .subscribe(data => this.user = data);
  }
}
