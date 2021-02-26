package com.recipe.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.metrics.buffering.BufferingApplicationStartup;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.metrics.jfr.FlightRecorderApplicationStartup;

@SpringBootApplication
public class RecipeApplication {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(RecipeApplication.class);
		// for some reason returns 405 (even if enable endpoint explicitly)
//		application.setApplicationStartup(new BufferingApplicationStartup(30_000));
		// requires additional parameters - -XX:+UnlockCommercialFeatures -XX:+FlightRecorder
		// but still does not work - NoClassDefFound (seems it's time to switch to java 11)
//		application.setApplicationStartup(new FlightRecorderApplicationStartup());
		application.run(args);
	}
}
