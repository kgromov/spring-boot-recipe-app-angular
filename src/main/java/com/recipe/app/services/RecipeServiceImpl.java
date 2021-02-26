package com.recipe.app.services;


import com.recipe.app.converters.RecipeConverter;
import com.recipe.app.domain.Recipe;
import com.recipe.app.dtos.RecipeDto;
import com.recipe.app.repositories.RecipeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
;import java.util.List;

/**
 * Created by jt on 6/13/17.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class RecipeServiceImpl implements RecipeService {
    private final RecipeRepository recipeRepository;
    private final RecipeConverter recipeConverter;

    @Override
    public List<Recipe> getRecipes() {
        return recipeRepository.findAll();
    }

    @Override
    @Transactional
    public void saveRecipe(RecipeDto recipeDto) {
        Recipe recipe = recipeConverter.convert(recipeDto);
        recipeRepository.save(recipe);
    }
}
