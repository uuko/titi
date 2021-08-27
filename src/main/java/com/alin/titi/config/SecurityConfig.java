package com.alin.titi.config;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
//                .antMatchers(HttpMethod.GET, "/teacher/**").authenticated()
                .antMatchers(HttpMethod.GET).permitAll()
                .antMatchers(HttpMethod.POST, "/teacher/**").permitAll()
                .antMatchers(HttpMethod.DELETE, "/teacher/**").permitAll()
                .antMatchers(HttpMethod.PUT, "/teacher/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .csrf().disable()
                .formLogin()
        ;

        http.cors().configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues());
    }
}