package com.example.homework_dao_hibernate.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SecurityConfiguration {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.formLogin(Customizer.withDefaults()).authorizeHttpRequests(request -> request
                .requestMatchers("/persons/by-city").permitAll()
                .anyRequest().authenticated());
        return http.build();
    }

    @Bean
    public UserDetailsService users() {
        UserDetails user = User.builder()
                .username("Yury")
                .password("{noop}qwerty")
                .build();
        return new InMemoryUserDetailsManager(user);
    }
}
