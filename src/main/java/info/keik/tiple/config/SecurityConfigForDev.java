package info.keik.tiple.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

@Configuration
@Profile("dev")
@EnableWebMvcSecurity
public class SecurityConfigForDev extends WebSecurityConfigurerAdapter {

	private static final Logger logger = LoggerFactory.getLogger(SecurityConfigForDev.class);

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.anyRequest().permitAll()

				.and()
				.formLogin().loginPage("/login").loginProcessingUrl("/session")
				.defaultSuccessUrl("/")
				.usernameParameter("id").passwordParameter("password")
				.permitAll()

				.and()
				.logout().logoutUrl("/logout").logoutSuccessUrl("/").permitAll();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.
				inMemoryAuthentication()
				.withUser("user1").password("password").roles("USER")
				.and()
				.withUser("user2").password("password").roles("USER");
	}

}
