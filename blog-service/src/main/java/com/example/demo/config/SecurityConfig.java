package com.example.demo.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

	private UserDetailsService userDetailsService;

	public SecurityConfig(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

	public UserDetailsManager userDetailsmanager(DataSource dataSource) {
		return new JdbcUserDetailsManager(dataSource);
	}

	@Bean
	public static PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
		return configuration.getAuthenticationManager();
	}

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

//      http.csrf().disable()
//        .authorizeHttpRequests((authorize) ->
//        //authorize.anyRequest().authenticated()
//        authorize.antMatchers("/api/auth/**").permitAll().anyRequest().authenticated()
//
//);
		http.authorizeHttpRequests(authorize -> authorize.antMatchers(HttpMethod.POST, "/api/auth/signup")
				.hasRole("ADMIN")
				.antMatchers(HttpMethod.POST, "/api/auth/signin").permitAll()
				.antMatchers(HttpMethod.GET, "/api/auth/").hasRole("ADMIN")
				.antMatchers(HttpMethod.DELETE, "/api/auth/{id}").hasRole("ADMIN"));
		http.httpBasic(Customizer.withDefaults());

		return http.build();
	}
}