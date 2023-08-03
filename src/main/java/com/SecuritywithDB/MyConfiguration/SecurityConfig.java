package com.SecuritywithDB.MyConfiguration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	
	@Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;
    @Value("${spring.datasource.driver-class-name}")
    private String driver;


	@Bean
	 SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http

				.authorizeHttpRequests(auth -> {
					auth.requestMatchers("/", "/public").permitAll();
					auth.requestMatchers("/secretpoint").hasAuthority("USER");
					auth.requestMatchers("/admin").hasAnyAuthority("ADMIN");
					auth.requestMatchers("/superadmin").hasAnyAuthority("ADMIN","SUPERADMIN");
					auth.requestMatchers("/test").hasAnyAuthority("READER","WRITER");
					
					auth.anyRequest().authenticated();

				})
				.csrf(AbstractHttpConfigurer::disable).cors(AbstractHttpConfigurer::disable)
				// .httpBasic(Customizer.withDefaults())
				.formLogin(Customizer.withDefaults());

		return http.build();
	}

@Bean
	 PasswordEncoder passwordEncoder() {

		return new BCryptPasswordEncoder();
	}

	@Bean
	 JdbcUserDetailsManager detailsManager(DataSource dataSource) {
		return new JdbcUserDetailsManager(dataSource);
	}

	@Bean
	 DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl(url);
		dataSource.setDriverClassName(driver);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		return dataSource;
	}



}
