export interface UsuarioModel{
  id: number;
  nombre: string;
  usuario: string;
  correo: string;
  direccion: Direccion;
}

export interface Direccion {
  street: string;
  suite: string;
  city: string;

}
