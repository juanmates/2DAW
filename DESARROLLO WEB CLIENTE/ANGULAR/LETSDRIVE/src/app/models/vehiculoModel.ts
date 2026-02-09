import { Autoescuela } from "./autoescuelaModel";

export interface Vehiculo {
  id_vehiculo?: number;
  matricula: string;
  marca_modelo: string;
  tipo_permiso: string;
  autoescuela_vehiculos?: Autoescuela;
}
