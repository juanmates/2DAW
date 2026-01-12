import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UsuarioModel } from '../../model/UsuarioModel';

@Injectable({
  providedIn: 'root',
})
export class UsuarioServicio {

  URL: string = "https://jsonplaceholder.typicode.com/users";

  constructor(private http: HttpClient){}

  getUsuarios() {
    return this.http.get<UsuarioModel[]>(this.URL);
  }

  getUsuario(id:number): Observable<UsuarioModel>{
    return this.http.get<UsuarioModel>(`${this.URL}/${id}`);
  }

}
