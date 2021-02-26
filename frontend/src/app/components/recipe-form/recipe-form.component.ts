import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {RecipeDto} from "../../domain/RecipeDto";
import {RecipeServiceService} from "../../services/recipe-service.service";

@Component({
  selector: 'app-recipe-form',
  templateUrl: './recipe-form.component.html',
  styleUrls: ['./recipe-form.component.scss']
})
export class RecipeFormComponent implements OnInit {
  recipe: RecipeDto;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private recipeService: RecipeServiceService) {
  }

  ngOnInit(): void {
  }

  onSubmit() {
    this.recipeService.saveRecipe(this.recipe).subscribe(result => this.gotoRecipes());
  }

  gotoRecipes() {
    this.router.navigate(['/recipes']);
  }
}
