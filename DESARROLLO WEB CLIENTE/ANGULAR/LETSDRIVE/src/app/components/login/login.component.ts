import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AuthService } from '../../services/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {

  email: string = '';
  contrasenya: string = '';

  constructor(private authService: AuthService, private router: Router) {}

  alPulsarEntrar() {
    this.authService.loginOregistro(this.email, this.contrasenya).subscribe({
      next: (user) => {
        console.log('Usuario recibido de Java:', user);

        if (user.rol === 'ADMIN') {
          this.router.navigate(['/admin-panel']);
        } else {
          this.router.navigate(['/autoescuelas']);
        }
      },
      error: (err) => {
        alert('Error al conectar con el servidor');
      }
    });
  }
}
