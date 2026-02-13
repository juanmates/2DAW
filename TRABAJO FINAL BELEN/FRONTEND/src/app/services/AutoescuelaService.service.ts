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

  buscarPorId(id: number): Observable<Autoescuela> {
    return this.http.get<Autoescuela>(`${this.url}/${id}`);
  }


  /*buscarPorCiudad(ciudad: string): Observable<Autoescuela[]> {
    return this.http.get<Autoescuela[]>(`${this.url}/buscar/ciudad/${ciudad}`);
  }*/


  /*getMedia(id: number): Observable<number> {
    return this.http.get<number>(`${this.url}/${id}/puntuacion-media`);
  }*/
}
