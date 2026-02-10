export interface Autoescuela {
  id?: number;
  nombre: string;
  cif: string;
  direccion?: Direccion;
  puntuacionMedia?: number; // Calculada por el backend
}

export interface Direccion {
  id_direccion?: number;
  calle: string;
  ciudad: string;
  codigoPostal: string;
  provincia: string;
}

export interface Usuario {
  id?: number;
  email: string;
  nombre: string;
  rol: string;
  contrasenya?: string;
}
