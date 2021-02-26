package com.recipe.app.dtos;

import com.recipe.app.domain.Ingredient;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * Created by jt on 6/21/17.
 */
@Data
@NoArgsConstructor
public class IngredientDto {
    private Long id;
    private Long recipeId;
    private String description;
    private BigDecimal amount;
    private UnitOfMeasureDto uom;

    public IngredientDto(Ingredient ingredient) {
        this.id = ingredient.getId();
        this.recipeId = ingredient.getRecipe().getId();
        this.description = ingredient.getDescription();
        this.amount = ingredient.getAmount();
        this.uom = new UnitOfMeasureDto(ingredient.getUom());
    }
}
