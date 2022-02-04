package com.nugrohosamiyono.studyjam.kernel;

import com.nugrohosamiyono.studyjam.application.filters.HeaderFilter;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeHttpRequests()
                .antMatchers("**").permitAll();

        var headerFilter = new HeaderFilter();
        http.addFilterBefore(headerFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
