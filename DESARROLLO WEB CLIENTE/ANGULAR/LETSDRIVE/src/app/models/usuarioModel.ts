import { Resenya } from "./resenyaModel";
import { Reserva } from "./reservaModel";

export interface Usuario {
  id?: number;
  email: string;
  contrasenya: string;
  nombre?: string;
  rol?: string;
  resenyas?: Resenya[];
  reservas?: Reserva[];
}
