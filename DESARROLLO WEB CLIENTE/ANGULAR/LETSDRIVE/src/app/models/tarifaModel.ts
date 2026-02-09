import { Autoescuela } from "./autoescuelaModel";

export interface Tarifa {
  id_tarifa?: number;
  tipo_permiso: string;
  precio_matricula: number;
  precio_clase: number;
  autoescuela_tarifas?: Autoescuela;
}
