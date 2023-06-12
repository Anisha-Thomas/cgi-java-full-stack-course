package com.example.demo.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SpringSecurityConfig {
	@Bean
	@Primary
	public UserDetailsManager userDetailsmanager(DataSource dataSource) {
		return new JdbcUserDetailsManager(dataSource);
	}

	@SuppressWarnings("removal")
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(configurer -> configurer.antMatchers(HttpMethod.GET, "/users")
				.hasRole("EMPLOYEE")
				.antMatchers(HttpMethod.POST, "/users/**").hasRole("EMPLOYEE")
				.antMatchers(HttpMethod.POST, "/users").hasRole("MANAGER")
				.antMatchers(HttpMethod.PUT, "/users/**").hasRole("ADMIN")
				.antMatchers(HttpMethod.DELETE, "/users/**").hasRole("ADMIN"));
		http.httpBasic(Customizer.withDefaults());
		http.csrf(csrf -> csrf.disable());
		// http.authorizeHttpRequests().antMatcher("/h2-console/**").permitAll();
		http.headers(headers -> headers.frameOptions().disable());
		return http.build();

	}
}
