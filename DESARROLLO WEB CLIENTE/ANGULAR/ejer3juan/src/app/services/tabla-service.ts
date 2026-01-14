import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AleatorioModel } from '../model/AleatorioModel';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class TablaService {

  URL:string = "https://randomuser.me/api/?results=10";

  constructor(private http: HttpClient){}

  getTabla(): Observable<AleatorioModel>{
    return this.http.get<AleatorioModel>(this.URL);
  }
}
