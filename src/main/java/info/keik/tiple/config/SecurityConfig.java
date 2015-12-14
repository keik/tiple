package info.keik.tiple.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

@Configuration
@EnableWebMvcSecurity
public class SecurityConfig {

	@Configuration
	@Profile("prod")
	static class ProductionSecurityConfig extends WebSecurityConfigurerAdapter {

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.authorizeRequests()
					.anyRequest()
					.permitAll()

					.and()
					.formLogin()
					.loginPage("/login")
					.loginProcessingUrl("/session")
					.defaultSuccessUrl("/")
					.usernameParameter("id")
					.passwordParameter("password")
					.permitAll()

					.and()
					.logout()
					.logoutUrl("/logout")
					.logoutSuccessUrl("/")
					.permitAll();
		}

		@Autowired
		public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
			// TODO JDBC
			auth.inMemoryAuthentication()
					.withUser("user")
					.password("password")
					.roles("USER");
		}
	}

	@Configuration
	@Profile("dev")
	static class DevelopmentSecurityConfig extends WebSecurityConfigurerAdapter {

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.authorizeRequests()
					.anyRequest()
					.permitAll()

					.and()
					.formLogin()
					.loginPage("/login")
					.loginProcessingUrl("/session")
					.defaultSuccessUrl("/")
					.usernameParameter("id")
					.passwordParameter("password")
					.permitAll()

					.and()
					.logout()
					.logoutUrl("/logout")
					.logoutSuccessUrl("/")
					.permitAll();
		}

		@Autowired
		public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
			auth.inMemoryAuthentication()
					.withUser("user")
					.password("password")
					.roles("USER");
		}
	}


}
