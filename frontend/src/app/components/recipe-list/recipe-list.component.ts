import {Component, OnInit} from '@angular/core';
import {RecipeDto} from "../../domain/RecipeDto";
import {RecipeServiceService} from "../../services/recipe-service.service";

@Component({
  selector: 'app-recipe-list',
  templateUrl: './recipe-list.component.html',
  styleUrls: ['./recipe-list.component.scss']
})
export class RecipeListComponent implements OnInit {
  public recipes: RecipeDto[];

  constructor(private recipeService: RecipeServiceService) { }

  ngOnInit(): void {
    this.recipeService.getRecipes().subscribe(data => this.recipes = data);
  }

  view(recipe: RecipeDto) {

  }

  update(recipe: RecipeDto) {
  }

  delete(recipeId: number) {
    this.recipeService.deleteRecipe(recipeId).subscribe(() => {
      this.recipes = this.recipes.filter(r => r.id !== recipeId);
      console.log('Recipe by id = ', recipeId, ' is deleted');
    });
  }
}
