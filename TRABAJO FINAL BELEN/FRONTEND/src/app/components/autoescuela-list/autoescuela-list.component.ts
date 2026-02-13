import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Observable } from 'rxjs';
import { Autoescuela } from '../../models/letsdrive.models';
import { AutoescuelaService } from '../../services/AutoescuelaService.service';

@Component({
  selector: 'app-autoescuela-list',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './autoescuela-list.component.html',
  styleUrls: ['./autoescuela-list.component.css']
})
export class AutoescuelaListComponent {

  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

pestanaActiva: { [key: number]: string | null } = {};

// Función interruptor: si pulsas la misma se cierra, si no, se abre la nueva
  togglePestana(autoId: number, nombrePestana: string): void {
    if (this.pestanaActiva[autoId] === nombrePestana) {
      this.pestanaActiva[autoId] = null;
    } else {
      this.pestanaActiva[autoId] = nombrePestana;
    }
  }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


  autoescuelas: Autoescuela[] = [];

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

  constructor(private autoService: AutoescuelaService) {}

  ngOnInit(): void {
    this.autoService.listarTodas().subscribe({
      next: (data) => {
        this.autoescuelas = data;
      },
      error: (e) => console.error('Error al cargar autoescuelas', e)
    });
  }

}
