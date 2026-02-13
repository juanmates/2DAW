export interface Autoescuela {
  id?: number;
  nombre: string;
  cif: string;
  direccion: Direccion;
  vehiculos: Vehiculo[];
  resenyas: Resenya[];
  tarifas: Tarifa[];
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

export interface Vehiculo {
  id?: number;
  matricula: string;
  marca_modelo: string;
  tipo_permiso: string
  autoescuela_vehiculos: Autoescuela;
}

export interface Resenya {
  id?: number;
  puntuacion: number;
  comentario: string;
  autoescuela_resenyas: Autoescuela;
  usuario_resenyas: Usuario;
}

export interface Tarifa {
  id?: number;
  tipo_permiso: string;
  precio_matricula: number;
  precio_clase: number;
}
