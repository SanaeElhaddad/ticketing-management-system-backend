package com.GestionTicket.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig {
	@Autowired
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

   // @Autowired
   // private MyUserDetailsService userDetailsService;

    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable() 
            .cors().disable()  
            .exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint)
            .and()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .authorizeRequests()
                .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()  
                .requestMatchers("/api/authenticate/**", "/api/**").permitAll()
                .requestMatchers("/api/authenticate").authenticated()
                .requestMatchers("/Client/**").hasAuthority("Client")
                .requestMatchers("/Consultant/**").hasAuthority("Consultant")
                .requestMatchers("/Manager/**").hasAuthority("Manager")
                .anyRequest().authenticated()
            .and()
            .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

   /* public void configure(WebSecurity web) {
        web.ignoring()
            .requestMatchers(HttpMethod.OPTIONS, "/**")
            .requestMatchers(HttpMethod.GET, "/open/api/**")
            .requestMatchers(HttpMethod.GET, "/open/api")
            .requestMatchers(HttpMethod.POST, "/api/authenticate");
    }*/
}