import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {RecipeListComponent} from "./components/recipe-list/recipe-list.component";
import {RecipeFormComponent} from "./components/recipe-form/recipe-form.component";


const routes: Routes = [
  { path: 'recipes', component: RecipeListComponent },
  { path: 'addRecipe', component: RecipeFormComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
