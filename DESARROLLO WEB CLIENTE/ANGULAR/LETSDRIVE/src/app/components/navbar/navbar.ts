import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-navbar',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './navbar.html',
  styleUrls: ['./navbar.css']
})
export class NavbarComponent {
  // Aquí más adelante inyectaremos el AuthService para cambiar el botón
  // de "Buscar/Login" por el nombre del usuario (u.getNombre())
}
