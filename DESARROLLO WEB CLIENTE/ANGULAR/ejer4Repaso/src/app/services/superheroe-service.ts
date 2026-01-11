import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Squad } from '../model/Squad';

@Injectable({
  providedIn: 'root',
})
export class SuperheroeService {

  constructor(private http: HttpClient) { }

  url: string = 'https://mdn.github.io/learning-area/javascript/oojs/json/superheroes.json';  

  getSuperheroes(): Observable<Squad>  {

    return this.http.get<Squad>(this.url);

  }
  
}
