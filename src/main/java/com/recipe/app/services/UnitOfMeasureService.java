package com.recipe.app.services;

import com.recipe.app.dtos.UnitOfMeasureDto;

import java.util.Set;

/**
 * Created by jt on 6/28/17.
 */
public interface UnitOfMeasureService {

    Set<UnitOfMeasureDto> getUnitsOfMeasure();
}
