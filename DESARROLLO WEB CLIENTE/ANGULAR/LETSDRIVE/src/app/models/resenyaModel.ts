import { Autoescuela } from './autoescuelaModel';
import { Usuario } from './usuarioModel';

export interface Resenya {
  id_resenya?: number;
  puntuacion: number;
  comentario?: string;
  autoescuela_reservas?: Autoescuela;
  usuario_resenyas?: Usuario;
}
