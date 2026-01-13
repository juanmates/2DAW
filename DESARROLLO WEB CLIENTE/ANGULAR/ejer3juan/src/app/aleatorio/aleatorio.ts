import { Component, OnInit } from '@angular/core';
import { AleatorioModel } from '../model/AleatorioModel';
import { Observable } from 'rxjs';
import { AleatorioService } from '../services/aleatorio-service';
import { AsyncPipe, CommonModule } from '@angular/common';

@Component({
  selector: 'app-aleatorio',
  imports: [AsyncPipe, CommonModule],
  templateUrl: './aleatorio.html',
  styleUrl: './aleatorio.css',
})
export class Aleatorio implements OnInit{
  aleatorio = new Observable<AleatorioModel>;

  constructor(private servicio: AleatorioService){}

  ngOnInit(): void {
    this.getAleatorio();
  }

  getAleatorio() {
    this.aleatorio = this.servicio.getAleatorio();
    console.log(this.servicio.getAleatorio())
  }
}
