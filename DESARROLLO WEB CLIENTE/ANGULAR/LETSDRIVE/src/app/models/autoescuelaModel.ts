import { Direccion } from "./direccionModel";
import { Resenya } from "./resenyaModel";
import { Tarifa } from "./tarifaModel";
import { Vehiculo } from "./vehiculoModel";

export interface Autoescuela {
  id?: number;
  nombre: string;
  cif: string;
  direccion: Direccion;
  vehiculos?: Vehiculo[];
  resenyas?: Resenya[];
  tarifas?: Tarifa[];
}
