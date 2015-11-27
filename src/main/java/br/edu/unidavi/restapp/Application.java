package br.edu.unidavi.restapp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author Michael J. Simons, 2014-02-08
 */
@Configuration
@EnableAutoConfiguration
@EnableScheduling
@ComponentScan
public class Application extends SpringBootServletInitializer {
    
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	return application.sources(Application.class);
    }

    public static void main(String... args) {
	System.setProperty("spring.profiles.default", System.getProperty("spring.profiles.default", "dev"));
	final ApplicationContext applicationContext = SpringApplication.run(Application.class, args);
    }
}
