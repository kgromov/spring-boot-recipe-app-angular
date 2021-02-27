package com.recipe.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.metrics.buffering.BufferingApplicationStartup;

@SpringBootApplication
public class RecipeApplication {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(RecipeApplication.class);
		// for some reason returns 405 (even if enable endpoint explicitly)
		application.setApplicationStartup(new BufferingApplicationStartup(4096));
		// requires additional parameters - -XX:+UnlockCommercialFeatures -XX:+FlightRecorder
		// but still does not work - NoClassDefFound (seems it's time to switch to java 11)
//		application.setApplicationStartup(new FlightRecorderApplicationStartup());
		application.run(args);
	}
}
