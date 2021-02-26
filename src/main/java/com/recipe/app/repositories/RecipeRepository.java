package com.recipe.app.repositories;

import com.recipe.app.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by jt on 6/13/17.
 */
public interface RecipeRepository extends CrudRepository<Recipe, Long> {
    List<Recipe> findAll();
}
