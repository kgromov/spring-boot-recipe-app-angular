import {Difficulty} from "./difficulty";

export class RecipeDto {
  id: number;
  description: string;
  prepTime: number;
  cookTime: number;
  servings: number;
  source: string;
  url: string;
  difficulty: Difficulty;
}
