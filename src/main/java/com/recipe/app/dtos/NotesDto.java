package com.recipe.app.dtos;

import com.recipe.app.domain.Notes;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by jt on 6/21/17.
 */
@Data
@NoArgsConstructor
public class NotesDto {
    private Long id;
    private String recipeNotes;

    public NotesDto(Notes notes) {
        this.id = notes.getId();
        this.recipeNotes = notes.getRecipeNotes();
    }
}
