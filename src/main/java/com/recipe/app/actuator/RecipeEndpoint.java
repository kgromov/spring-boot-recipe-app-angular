package com.recipe.app.actuator;

import com.recipe.app.dtos.RecipeDto;
import com.recipe.app.services.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.actuate.endpoint.web.annotation.RestControllerEndpoint;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RestControllerEndpoint(id = "recipes")
@RequiredArgsConstructor
public class RecipeEndpoint {
    private final RecipeService recipeService;

    @GetMapping()
    public List<RecipeDto> getRecipes() {
        return recipeService.getRecipes().stream()
                .map(RecipeDto::new)
                .collect(Collectors.toList());
    }

    @GetMapping("{recipeId}")
    public RecipeDto getRecipe(@PathVariable Long recipeId) {
        return null;
    }

    @PostMapping()
    public void createRecipe(@RequestBody RecipeDto recipeDto) {
        recipeService.saveRecipe(recipeDto);
    }

    @DeleteMapping("{recipeId}")
    public RecipeDto deleteRecipe(@PathVariable Long recipeId) {
        return null;
    }
}
