package com.recipe.app.dtos;

import com.recipe.app.domain.Category;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by jt on 6/21/17.
 */
@Data
@NoArgsConstructor
public class CategoryDto {
    private Long id;
    private String description;

    public CategoryDto(Category category) {
        this.id = category.getId();
        this.description = category.getDescription();
    }
}
