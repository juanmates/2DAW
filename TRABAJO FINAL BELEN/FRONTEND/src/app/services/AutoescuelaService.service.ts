import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Autoescuela } from '../models/letsdrive.models';

@Injectable({ providedIn: 'root' })
export class AutoescuelaService {

  private url = 'http://localhost:8080/api/autoescuelas';

  constructor(private http: HttpClient) {}

  // Lista principal
  listarTodas(): Observable<Autoescuela[]> {
    return this.http.get<Autoescuela[]>(this.url);
  }

  // Detalle de una autoescuela
  buscarPorId(id: number): Observable<Autoescuela> {
    return this.http.get<Autoescuela>(`${this.url}/${id}`);
  }

  // Filtrar por ciudad (usando tu endpoint específico)
  buscarPorCiudad(ciudad: string): Observable<Autoescuela[]> {
    return this.http.get<Autoescuela[]>(`${this.url}/buscar/ciudad/${ciudad}`);
  }

  // Obtener la media (usando tu lógica de negocio del backend)
  getMedia(id: number): Observable<number> {
    return this.http.get<number>(`${this.url}/${id}/puntuacion-media`);
  }
}
