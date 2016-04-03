package info.keik.tiple.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	UserDetailsService userDetailsService;

	@Override
	public void configure(WebSecurity web) throws Exception {
		web
				.ignoring()
				.antMatchers("/**/bundle.js", "/**/bundle.css");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.authorizeRequests()
				// create or update or delete question
				.antMatchers(HttpMethod.POST, "/q").hasRole("USER")
				.antMatchers(HttpMethod.PUT, "/q").hasRole("USER")
				.antMatchers(HttpMethod.DELETE, "/q").hasRole("USER")
				// create or update or delete answer
				.antMatchers(HttpMethod.POST, "/q/**/answers/").hasRole("USER")
				.antMatchers(HttpMethod.PUT, "/q/**/answers/").hasRole("USER")
				.antMatchers(HttpMethod.DELETE, "/q/**/answers/").hasRole("USER")
				// create or update or delete vote
				.antMatchers(HttpMethod.POST, "/q/**/votes").hasRole("USER")
				.antMatchers(HttpMethod.PUT, "/q/**/votes").hasRole("USER")
				.antMatchers(HttpMethod.DELETE, "/q/**/votes").hasRole("USER")
				.anyRequest().permitAll()

				.and()
				.csrf().disable()

				.formLogin().loginPage("/login").loginProcessingUrl("/session")
				.defaultSuccessUrl("/")
				.usernameParameter("id").passwordParameter("password")
				.permitAll()

				.and()
				.logout().logoutUrl("/logout").logoutSuccessUrl("/").permitAll();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth
				.userDetailsService(userDetailsService)
				.passwordEncoder(passwordEncoder());
	}

}
