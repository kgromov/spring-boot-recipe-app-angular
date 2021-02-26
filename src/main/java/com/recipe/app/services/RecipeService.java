package com.recipe.app.services;



import com.recipe.app.domain.Recipe;
import com.recipe.app.dtos.RecipeDto;

import java.util.List;

/**
 * Created by jt on 6/13/17.
 */
public interface RecipeService {
    List<Recipe> getRecipes();

    void saveRecipe(RecipeDto recipeDto);
}
