package com.recipe.app.converters;

import com.recipe.app.domain.Recipe;
import com.recipe.app.dtos.RecipeDto;
import org.springframework.stereotype.Component;

@Component
public class RecipeConverter {

    public Recipe convert(RecipeDto dto) {
        final Recipe recipe = new Recipe();
        recipe.setId(dto.getId());
        recipe.setCookTime(dto.getCookTime());
        recipe.setPrepTime(dto.getPrepTime());
        recipe.setDescription(dto.getDescription());
        recipe.setDifficulty(dto.getDifficulty());
        recipe.setDirections(dto.getDirections());
        recipe.setServings(dto.getServings());
        recipe.setSource(dto.getSource());
        recipe.setUrl(dto.getUrl());
//        recipe.setNotes(notesConverter.convert(dto.getNotes()));

        return recipe;
    }
}
