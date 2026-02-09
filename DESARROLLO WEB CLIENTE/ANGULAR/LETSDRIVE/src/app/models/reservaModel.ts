import { Usuario } from './usuarioModel';

export interface Reserva {
  id_reserva?: number;
  fecha_reserva: string | Date;
  usuario_reservas?: Usuario;
}
