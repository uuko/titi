package com.alin.titi.config;

import com.alin.titi.filter.JwtAuthorizationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.filter.CorsFilter;
import org.zalando.problem.spring.web.advice.security.SecurityProblemSupport;
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Import(SecurityProblemSupport.class)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private CorsFilter corsFilter;

    @Autowired
    private SecurityProblemSupport securityProblemSupport;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .addFilterBefore(corsFilter, UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling()
                // 当用户无权访问资源时发送 401 响应
                .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
                // 当用户访问资源因权限不足时发送 403 响应
                .accessDeniedHandler(securityProblemSupport)
                .and()
                // 禁用 CSRF
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()
                .logout().logoutUrl("/teacher/logout").and()
//
                .authorizeRequests()
//                .antMatchers(HttpMethod.GET, "/teacher/**").authenticated()
                .antMatchers(HttpMethod.POST, "/teacher/login").permitAll()
                .antMatchers(HttpMethod.POST,"/teacher/register").permitAll()
                .antMatchers(HttpMethod.GET,"/downloadFile/**").permitAll()
                .antMatchers(HttpMethod.GET,"/article/downloadFile/**").permitAll()
                .antMatchers(HttpMethod.GET,"/teacher/changePassword*").permitAll()
                .antMatchers(HttpMethod.POST,"/teacher/resetPassword*").permitAll()
                .antMatchers(HttpMethod.POST,"/teacher/savePassword").permitAll()
//                .antMatchers(HttpMethod.GET).permitAll()
//                .antMatchers(HttpMethod.POST, "/teacher/**","/article/**","/admin/**").permitAll()
//                .antMatchers(HttpMethod.DELETE, "/teacher/**","/article/**","/admin/**").permitAll()
//                .antMatchers(HttpMethod.PUT, "/teacher/**","/article/**","/admin/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .csrf().disable()
                .formLogin()
//
                .and()
                // 不需要 session（不创建会话）
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .apply(securityConfigurationAdapter());
        ;

        http.cors().configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues());
    }

    private JwtConfigurer securityConfigurationAdapter() throws Exception{
        return new JwtConfigurer(new JwtAuthorizationFilter(authenticationManager()));
    }
}