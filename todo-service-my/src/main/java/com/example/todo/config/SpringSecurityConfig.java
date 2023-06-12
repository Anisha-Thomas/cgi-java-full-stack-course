package com.example.todo.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SpringSecurityConfig extends WebSecurityConfiguration {

//	@Bean
//	@Primary
//	public InMemoryUserDetailsManager userDetailsManager() {
//		UserDetails john = User.builder().username("john").password("{noop}test123").roles("EMPLOYEE").build();
//		UserDetails marry = User.builder().username("marry").password("{noop}test123").roles("EMPLOYEE", "MANAGER")
//				.build();
//		UserDetails susan = User.builder().username("susan").password("{noop}test123")
//				.roles("EMPLOYEE", "MANAGER", "ADMIN").build();
//		return new InMemoryUserDetailsManager(john, marry, susan);
//	}

	@Bean
	@Primary
	public UserDetailsManager userDetailsmanager(DataSource dataSource) {
		return new JdbcUserDetailsManager(dataSource);
	}

	@SuppressWarnings("removal")
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(configurer -> configurer.requestMatchers(HttpMethod.GET, "/todo")
				.hasRole("EMPLOYEE")
				.requestMatchers(HttpMethod.POST, "/todo/**").hasRole("EMPLOYEE")
				.requestMatchers(HttpMethod.POST, "/todo").hasRole("MANAGER")
				.requestMatchers(HttpMethod.PUT, "/todo/**").hasRole("ADMIN")
				.requestMatchers(HttpMethod.DELETE, "/todo/**").hasRole("ADMIN"));
		http.httpBasic(Customizer.withDefaults());
		http.csrf(csrf -> csrf.disable());
		// http.authorizeHttpRequests().antMatcher("/h2-console/**").permitAll();
		http.headers(headers -> headers.frameOptions().disable());
		return http.build();

	}
}
