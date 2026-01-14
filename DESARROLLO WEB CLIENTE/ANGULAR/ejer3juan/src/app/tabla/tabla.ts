import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { AleatorioModel } from '../model/AleatorioModel';
import { TablaService } from '../services/tabla-service';
import { AsyncPipe, CommonModule } from '@angular/common';

@Component({
  selector: 'app-tabla',
  imports: [CommonModule, AsyncPipe],
  templateUrl: './tabla.html',
  styleUrl: './tabla.css',
})
export class Tabla implements OnInit{

  aleatorio = new Observable<AleatorioModel>;

  constructor(private servicio: TablaService){}


  ngOnInit(): void {
    this.aleatorio = this.servicio.getTabla();
  }
}
