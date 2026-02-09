import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AutoescuelaService } from '../../services/autoescuela.service';
import { Autoescuela } from '../../models/autoescuelaModel';

@Component({
  selector: 'app-lista-autoescuelas',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './lista-autoescuelas.html',
  styleUrl: './lista-autoescuelas.css'
})
export class ListaAutoescuelasComponent implements OnInit {

  // Array donde guardamos lo que venga del backend
  autoescuelas: Autoescuela[] = [];

  constructor(private autoescuelaService: AutoescuelaService) { }

  ngOnInit(): void {
    this.cargarAutoescuelas();
  }

  cargarAutoescuelas(): void {
    this.autoescuelaService.getAutoescuelas().subscribe({
      next: (data) => {
        this.autoescuelas = data;
        console.log('Datos recibidos:', data);
      },
      error: (err) => {
        console.error('Error al conectar con el backend:', err);
      }
    });
  }
}
