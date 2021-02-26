package com.recipe.app.services;

import com.recipe.app.dtos.UnitOfMeasureDto;
import com.recipe.app.repositories.UnitOfMeasureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created by jt on 6/28/17.
 */
@Service
@RequiredArgsConstructor
public class UnitOfMeasureServiceImpl implements UnitOfMeasureService {
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    @Override
    public Set<UnitOfMeasureDto> getUnitsOfMeasure() {
        return StreamSupport.stream(unitOfMeasureRepository.findAll()
                .spliterator(), false)
                .map(UnitOfMeasureDto::new)
                .collect(Collectors.toSet());
    }
}
