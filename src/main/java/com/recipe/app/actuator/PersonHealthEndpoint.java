package com.recipe.app.actuator;

import io.micrometer.core.instrument.MeterRegistry;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Endpoint(id = "personHealth")
@Component
@RequiredArgsConstructor
public class PersonHealthEndpoint {
    private final MeterRegistry meterRegistry;

    private static final List<PersonDto> PERSONS = Arrays.asList(
            new PersonDto("Jack", "Sparrow", new HealthInfo(120.70, 36.6, 170, 70)),
            new PersonDto("Eddy", "Hall", new HealthInfo(140.80, 36, 190, 170))
    );

    @ReadOperation
    public List<PersonDto> getPersons() {
        meterRegistry.counter("personHealth_getPersons").increment();
        return PERSONS;
    }

    // Caused by: java.lang.IllegalStateException: Unable to map duplicate endpoint operations: why if name is required parameter?
    /*@ReadOperation
    public PersonDto getPerson(String name) {
        return PERSONS.stream()
                .filter(p -> p.getFirstName().equals(name) || p.getLastName().equals(name))
                .findFirst().orElse(null);
    }*/

    @ReadOperation
    public HealthInfo getPersonHealth(@Selector String healthParameter) {
        meterRegistry.counter("personHealth_getPersonHealthBySelector").increment();
        return PERSONS.get(0).getHealthInfo();
    }

}