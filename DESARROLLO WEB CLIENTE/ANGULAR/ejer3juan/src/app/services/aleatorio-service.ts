import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AleatorioModel } from '../model/AleatorioModel';

@Injectable({
  providedIn: 'root',
})
export class AleatorioService {

  URL:string = "https://randomuser.me/api/";

  constructor(private http: HttpClient){}

  getAleatorio(): Observable<AleatorioModel>{
    return this.http.get<AleatorioModel>(this.URL);
  }

}
