package info.keik.tiple;

import info.keik.tiple.config.ApplicationConfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration(exclude = { SecurityAutoConfiguration.class })
@ComponentScan(basePackageClasses = { ApplicationConfig.class })
public class Application {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}

}
