import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {RecipeDto} from "../domain/RecipeDto";

@Injectable({
  providedIn: 'root'
})
export class RecipeServiceService {
  private readonly recipeUrl: string;

  constructor(private http: HttpClient) {
    this.recipeUrl = 'http://localhost:8080/recipes';
  }

  public getRecipes(): Observable<RecipeDto[]> {
    return this.http.get<RecipeDto[]>(this.recipeUrl);
  }

  public saveRecipe(recipeDto: RecipeDto): Observable<RecipeDto> {
    return this.http.post<RecipeDto>(this.recipeUrl, recipeDto);
  }

  public updateRecipe(recipeDto: RecipeDto): Observable<RecipeDto> {
    return this.http.put<RecipeDto>(this.recipeUrl + '/' + recipeDto.id, recipeDto);
  }

  public deleteRecipe(recipeId: number): Observable<void> {
    return this.http.delete<void>(this.recipeUrl + '/' + recipeId);
  }
}
