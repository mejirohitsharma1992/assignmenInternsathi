package com.internsathi.springwebapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private AuthenticationSuccessHandler customSuccessHandler;

	@Bean
	public UserDetailsService getuserDetailsService() {
		return new UserDetailsImpl();
	}

	@Bean
	public BCryptPasswordEncoder getpasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider getDaoAuthenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(getuserDetailsService());
		daoAuthenticationProvider.setPasswordEncoder(getpasswordEncoder());
		return daoAuthenticationProvider;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.authenticationProvider(getDaoAuthenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// Rule 1: URLs starting with "/admin/" require the "ADMIN" role for access.
		http.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN")

				// Rule 2: URLs starting with "/users/" require the "USER" role for access.
				.antMatchers("/users/**").hasRole("USER").antMatchers("/teacher/**").access("hasRole('ROLE_TEACHER')")

				// Rule 3: All other URLs are permitted without any security requirements.
				.antMatchers("/**").permitAll()

				// The "formLogin()" method is used to configure the form-based authentication.
				// It specifies the login page and the URL where the login form data should be
				// submitted for processing.

				// Rule 4: The login page URL is set to "/signIn".
				.and().formLogin().loginPage("/signIn")

				// Rule 5: The URL where the login form data should be submitted is set to
				// "/login".
				.loginProcessingUrl("/login")

				// Rule 6: After successful login, the user is redirected to custom URL.
				.successHandler(customSuccessHandler)

				// The "csrf()" method is used to configure Cross-Site Request Forgery (CSRF)
				// protection.

				// Rule 7: CSRF protection is disabled for simplicity in this configuration.
				.and().csrf().disable();
	}

}
