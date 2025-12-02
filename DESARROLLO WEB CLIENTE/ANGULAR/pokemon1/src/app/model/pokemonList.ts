export interface pokemonList {
  count: number;
  next: string;
  previous: null;
  results: Result[];
}

export interface Result {
  name:string;
  url: string;
}
