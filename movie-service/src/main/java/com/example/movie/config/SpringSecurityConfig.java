package com.example.movie.config;

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

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//		http.authorizeHttpRequests(configurer -> configurer.requestMatchers(HttpMethod.GET, "/movies")
//				.hasRole("EMPLOYEE")
//				.requestMatchers(HttpMethod.POST, "/movies/**").hasRole("EMPLOYEE")
//				.requestMatchers(HttpMethod.POST, "/movies").hasRole("EMPLOYEE")
//				.requestMatchers(HttpMethod.PUT, "/movies/**").hasRole("EMPLOYEE")
//				.requestMatchers(HttpMethod.DELETE, "/movies/**").hasRole("EMPLOYEE"));
//		http.httpBasic(Customizer.withDefaults());
//		http.csrf(csrf -> csrf.disable());
//		// http.authorizeHttpRequests().antMatcher("/h2-console/**").permitAll();
//		http.headers(headers -> headers.frameOptions().disable());
//		return http.build();
		http.csrf().disable().authorizeHttpRequests((authorize) ->
		// authorize.anyRequest().authenticated()
		authorize.requestMatchers("/movies/**").permitAll().anyRequest().authenticated()

		);
		return http.build();
	}
}
