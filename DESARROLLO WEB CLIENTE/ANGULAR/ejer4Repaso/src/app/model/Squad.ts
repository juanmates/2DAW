export interface Squad {
  squadName: string;
  homeTown: string;
  formed: number;
  members: Miembro[]
}

export interface Miembro {
  name: string;
  age: number;
  secretIdentity: string;
  powers: string[];
}
