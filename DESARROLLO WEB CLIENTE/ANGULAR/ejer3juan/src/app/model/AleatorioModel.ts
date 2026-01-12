export interface AleatorioModel{
  results: Persona[];
}

export interface Persona{
  name: {first: string, last:string};
  email: string;
  location: {city:string}
  picture: {large: string}
}
