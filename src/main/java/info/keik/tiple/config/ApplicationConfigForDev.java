package info.keik.tiple.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("dev")
@Configuration
@ComponentScan(basePackages = {
		"info.keik.tiple.config",
		"info.keik.**.controller",
		"info.keik.tiple.**.security",
		"info.keik.**.service.mock" })
public class ApplicationConfigForDev {

}
