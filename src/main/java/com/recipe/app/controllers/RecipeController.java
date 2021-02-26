package com.recipe.app.controllers;

import com.recipe.app.dtos.RecipeDto;
import com.recipe.app.services.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("recipes")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class RecipeController {
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

    @PutMapping("{recipeId}")
    public RecipeDto updateRecipe(@PathVariable Long recipeId) {
        return null;
    }

    @DeleteMapping("{recipeId}")
    public RecipeDto deleteRecipe(@PathVariable Long recipeId) {
        return null;
    }
}
