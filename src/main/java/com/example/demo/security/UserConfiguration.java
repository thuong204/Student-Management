package com.example.demo.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class UserConfiguration {
	
//	@Bean
//	@Autowired
//	public JdbcUserDetailsManager jdbcUserDetailsManager(DataSource dataSource) {
//		JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);
//		return userDetailsManager;
//	}
//	

//
    @Bean
    @Autowired
    public JdbcUserDetailsManager jdbcUserDetailsManager(DataSource dataSource){
        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);
        userDetailsManager.setUsersByUsernameQuery("SELECT id, pw, active FROM accounts WHERE id=?");
        userDetailsManager.setAuthoritiesByUsernameQuery("SELECT id, role FROM roles WHERE id=?");
        return userDetailsManager;
    }

//	@Bean
//	public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
//		UserDetails thuong = User.withUsername("thuong").password("{noop}123456").roles("teacher").build();
//		UserDetails thanh = User.withUsername("thanh").password("{noop}thanh123").roles("manager").build();
//		UserDetails huy = User.withUsername("huy").password("{noop}huy1111").roles("student").build();
//		UserDetails tien = User.withUsername("tien").password("{noop}123456").roles("admin").build();
//		return new InMemoryUserDetailsManager(thuong,thanh,huy,tien);
//		
//		
//		
//	}
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(
				configurer -> configurer
					.requestMatchers(HttpMethod.GET,"/api/students/").hasAnyRole("TEACHER","MANAGER","ADMIN")
					.requestMatchers(HttpMethod.GET,"/api/students/**").hasAnyRole("TEACHER","MANAGER","ADMIN")
					.requestMatchers(HttpMethod.POST,"/api/students").hasAnyRole("MANAGER","ADMIN")
					.requestMatchers(HttpMethod.PUT,"/api/students/{id}").hasAnyRole("MANAGER","ADMIN")
					.requestMatchers(HttpMethod.DELETE,"/api/students/{id}").hasRole("ADMIN")
		);
		http.httpBasic(Customizer.withDefaults());
		http.csrf(csrf->csrf.disable());
		return http.build();
	}
	

}
