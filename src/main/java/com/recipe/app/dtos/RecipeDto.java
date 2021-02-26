package com.recipe.app.dtos;

import com.recipe.app.domain.Difficulty;
import com.recipe.app.domain.Recipe;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by jt on 6/21/17.
 */
@Data
@NoArgsConstructor
// FIXME: validators -> entity
public class RecipeDto {
    private Long id;

    @NotBlank
    @Size(min = 3, max = 255)
    private String description;

    @Min(1)
    @Max(999)
    private Integer prepTime;

    @Min(1)
    @Max(999)
    private Integer cookTime;

    @Min(1)
    @Max(100)
    private Integer servings;
    private String source;

    @URL
    private String url;

    @NotBlank
    private String directions;

    private Set<IngredientDto> ingredients = new HashSet<>();
    private Byte[] image;
    private Difficulty difficulty;
    private NotesDto notes;
    private Set<CategoryDto> categories = new HashSet<>();

    public RecipeDto(Recipe recipe) {
        this.id = recipe.getId();
        this.description = recipe.getDescription();
        this.prepTime = recipe.getPrepTime();
        this.cookTime = recipe.getCookTime();
        this.servings = recipe.getServings();
        this.source = recipe.getSource();
        this.url = recipe.getUrl();
        this.directions = recipe.getDirections();
        this.image = recipe.getImage();
        this.difficulty = recipe.getDifficulty();
        setNotes(recipe);
        setCategories(recipe);
        setIngredients(recipe);
    }

    public void setNotes(Recipe recipe) {
        this.ingredients = recipe.getIngredients().stream().map(IngredientDto::new).collect(Collectors.toSet());
    }

    public void setCategories(Recipe recipe) {
        this.categories = recipe.getCategories().stream().map(CategoryDto::new).collect(Collectors.toSet());
    }

    public void setIngredients(Recipe recipe) {
        this.ingredients = recipe.getIngredients().stream().map(IngredientDto::new).collect(Collectors.toSet());
    }
}
