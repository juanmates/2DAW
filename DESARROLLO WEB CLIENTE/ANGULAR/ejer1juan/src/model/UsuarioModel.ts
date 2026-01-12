export interface UsuarioModel {
  name: string;
  username: string;
  email: string;
  address: Direccion;
}

export interface Direccion {
  street: string;
  suite: string;
  city: string;
}
