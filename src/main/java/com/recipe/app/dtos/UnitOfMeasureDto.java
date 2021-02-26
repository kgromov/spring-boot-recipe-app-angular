package com.recipe.app.dtos;

import com.recipe.app.domain.UnitOfMeasure;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by jt on 6/21/17.
 */
@Data
@NoArgsConstructor
public class UnitOfMeasureDto {
    private Long id;
    private String description;

    public UnitOfMeasureDto(UnitOfMeasure unitOfMeasure) {
        this.id = unitOfMeasure.getId();
        this.description = unitOfMeasure.getDescription();
    }
}
