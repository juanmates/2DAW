export interface UsuarioModel {
  id: number;
  name:string;
  username:string;
  email:string;
  phone:string;
  address: Direccion;
}

export interface Direccion {
  street:string;
  suite:string;
  city:string;
}
