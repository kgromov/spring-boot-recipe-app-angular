package com.recipe.app.micrometer;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Component
public class DemoMetrics {
    private final Counter demoCounter;
    private final AtomicInteger demoGauge;

    public DemoMetrics(MeterRegistry meterRegistry) {
        this.demoCounter = meterRegistry.counter("demo_counter");
        this.demoGauge = meterRegistry.gauge("demo_gauge", new AtomicInteger(0));
    }

    public void getRandomMetricsData() {
        int randomNumberInRange = getRandomNumberInRange(0, 100);
        demoGauge.set(randomNumberInRange);
        demoCounter.increment();
        log.debug("{}", randomNumberInRange);
    }

    private static int getRandomNumberInRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}
