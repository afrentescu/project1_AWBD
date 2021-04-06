package com.project.project1.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@Profile("h2")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("professor")
                .password(passwordEncoder().encode("1234"))
                .roles("PROFESSOR")
                .and()
                .withUser("student")
                .password(passwordEncoder()
                        .encode("1234")).roles("STUDENT");}

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()/*.anyRequest().authenticated()*/.antMatchers("/")
                .hasAnyRole("PROFESSOR","STUDENT").antMatchers("/professor/**")
                .hasRole("PROFESSOR").and().formLogin().loginPage("/showLogInForm")
                .loginProcessingUrl("/authUser").failureUrl("/login").permitAll().and().exceptionHandling().accessDeniedPage("/access_denied");

    }

}

