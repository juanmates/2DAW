import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Usuario } from '../models/usuarioModel';
import { Observable } from 'rxjs';

@Injectable({ providedIn: 'root' })
export class AuthService {
  // La dirección de tu Java
  private API_URL = 'http://localhost:8080/api/usuarios';

  constructor(private http: HttpClient) { }

  // Esta función envía el email y la clave a Java
  loginOregistro(email: string, contrasenya: string): Observable<Usuario> {
    const datos = { email, contrasenya };

    // Hacemos un POST y devolvemos el Observable
    return this.http.post<Usuario>(this.API_URL + '/login-directo', datos);
  }
}
