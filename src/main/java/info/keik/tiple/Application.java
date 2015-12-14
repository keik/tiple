package info.keik.tiple;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@EnableAutoConfiguration
public class Application {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}

	@Profile("prod")
	@Configuration
	@ComponentScan(basePackages = {
			"info.keik.tiple.config",
			"**.controller",
			"**.service.impl" })
	static class ProductionConfiguration {

	}

	@Profile("dev")
	@Configuration
	@ComponentScan(basePackages = {
			"info.keik.tiple.config",
			"**.controller",
			"**.service.mock" })
	static class DevelopmentConfiguration {

	}
}
