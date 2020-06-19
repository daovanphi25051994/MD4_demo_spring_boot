package com.example.demo.config;

import com.example.demo.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private CustomSuccessHandler customSuccessHandler;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        PasswordEncoder encoder =
//                PasswordEncoderFactories.createDelegatingPasswordEncoder();
//        auth
//                .inMemoryAuthentication()
//                .withUser("user")
//                .password(encoder.encode("password"))
//                .roles("USER")
//                .and()
//                .withUser("admin")
//                .password(encoder.encode("admin"))
//                .roles("USER", "ADMIN");

        auth.userDetailsService((UserDetailsService) customerService)
                .passwordEncoder(NoOpPasswordEncoder.getInstance());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "/home").access("hasRole('USER')")
                .antMatchers("/customer/**", "/product/**", "/province/**", "/customers").access("hasRole('ADMIN')")
                .antMatchers("/dba/**").access("hasRole('ADMIN') and hasRole('DBA')")
                .and().formLogin().loginPage("/login").loginProcessingUrl("/do_login").successHandler(customSuccessHandler)
                .usernameParameter("username").passwordParameter("password")
                .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .and().exceptionHandling().accessDeniedPage("/Access_Denied").and().csrf().disable();
    }
}