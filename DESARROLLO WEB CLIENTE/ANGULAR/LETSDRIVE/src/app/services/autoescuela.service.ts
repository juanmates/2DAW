import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Autoescuela } from '../models/autoescuelaModel';

@Injectable({
  providedIn: 'root'
})
export class AutoescuelaService {

  private API_URL = 'http://localhost:8080/api/autoescuelas';

  constructor(private http: HttpClient) { }

  // Obtener la lista completa
  getAutoescuelas(): Observable<Autoescuela[]> {
    return this.http.get<Autoescuela[]>(this.API_URL);
  }

  // Obtener una sola por ID
  getAutoescuela(id: number): Observable<Autoescuela> {
    return this.http.get<Autoescuela>(`${this.API_URL}/${id}`);
  }

  // Crear una nueva
  crear(autoescuela: Autoescuela): Observable<Autoescuela> {
    return this.http.post<Autoescuela>(this.API_URL, autoescuela);
  }
}
