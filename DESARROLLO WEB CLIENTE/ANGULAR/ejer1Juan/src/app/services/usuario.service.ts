import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UsuarioModel } from '../model/Usuario';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  url:string = "https://jsonplaceholder.typicode.com/users";

  constructor(private http: HttpClient) {}

  getUsuarios() {
    return this.http.get<UsuarioModel[]>(this.url);
  }

  getUsuario(id:number) {
    console.log(`${this.url}/${id}`)
    return this.http.get<UsuarioModel>(`${this.url}/${id}}`)
  }

}
