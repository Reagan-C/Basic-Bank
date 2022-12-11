package com.finservice.basicbank.config;

import com.finservice.basicbank.filter.JWTTokenGeneratorFilter;
import com.finservice.basicbank.filter.JWTTokenValidatorFilter;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.Arrays;
import java.util.Collections;


@Configuration
public class ProjectSecurityConfig {

    @Autowired
    private JWTTokenGeneratorFilter tokenGeneratorFilter;

    @Autowired
    private JWTTokenValidatorFilter tokenValidatorFilter;
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.cors().configurationSource(new CorsConfigurationSource() {
                    @Override
                    public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
                        CorsConfiguration corsconfig = new CorsConfiguration();
                        corsconfig.setAllowedOrigins(Collections.singletonList("*"));
                        corsconfig.setAllowedMethods(Collections.singletonList("*"));
                        corsconfig.setAllowCredentials(true);
                        corsconfig.setAllowedHeaders(Collections.singletonList("*"));
                        corsconfig.setExposedHeaders(Arrays.asList("Authorization"));
                        corsconfig.setMaxAge(3600L);
                        return corsconfig;
                    }
                })
                .and().csrf().ignoringRequestMatchers("/contact", "/register")
                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                .and().addFilterAfter(tokenGeneratorFilter, BasicAuthenticationFilter.class)
                .addFilterBefore(tokenValidatorFilter, BasicAuthenticationFilter.class)
                .authorizeHttpRequests()
                .requestMatchers("/myAccount").hasRole("USER")
                .requestMatchers("/myBalance").hasAnyRole("ADMIN", "USER")
                .requestMatchers("/myLoans").hasRole("USER")
                .requestMatchers("/myCards").hasRole("USER")
                .requestMatchers("/user").authenticated()
                .requestMatchers("/notices", "/contact", "/register").permitAll()
                .and().formLogin()
                .and().httpBasic()
                .and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
