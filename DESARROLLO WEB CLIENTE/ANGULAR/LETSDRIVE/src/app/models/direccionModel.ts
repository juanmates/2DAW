import { Autoescuela } from "./autoescuelaModel";

export interface Direccion {
  id_direccion?: number;
  calle: string;
  codigoPostal: string;
  ciudad: string;
  provincia: string;
  piso_puerta: string;
  pais: string;
  autoescuela?: Autoescuela;
}
