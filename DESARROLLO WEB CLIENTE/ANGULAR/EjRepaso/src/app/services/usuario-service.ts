import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UsuarioModel } from '../model/usuario';


@Injectable({
  providedIn: 'root',
})
export class UsuarioService {
  private url: string = 'https://jsonplaceholder.typicode.com/users';
  constructor(private httpClient: HttpClient) {}

  getUsuarios() {
    return this.httpClient.get<UsuarioModel[]>(this.url);
  }

  getUsuario(id:number) {
    console.log(`${this.url}/${id}`)
    return this.httpClient.get<UsuarioModel>(`${this.url}/${id}`);
  }

}
