package com.neurofleetx.auth.config;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeHttpRequests()
            .requestMatchers("/auth/**").permitAll()   // with auth type of request he can call login and register api
            .requestMatchers("/admin/**").hasRole("ADMIN")
            .requestMatchers("/manager/**").hasRole("MANAGER")
            .requestMatchers("/driver/**").hasRole("DRIVER")
            .requestMatchers("/customer/**").hasRole("CUSTOMER")
            .anyRequest().authenticated();

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}
