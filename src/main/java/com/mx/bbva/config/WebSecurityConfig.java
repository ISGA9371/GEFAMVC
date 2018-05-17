package com.mx.bbva.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
// @EnableWebSecurity = @EnableWebMVCSecurity + Extra features
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    DbAuthenticationService dbAuthenticationService;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        // For User in database.
        auth.userDetailsService(dbAuthenticationService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();

        http.sessionManagement().maximumSessions(2);

        http.authorizeRequests().antMatchers("/").authenticated();
        // The pages does not require login
        http.authorizeRequests().antMatchers("/login", "/logout").permitAll();

        // /userInfo page requires login as USER or ADMIN.
        // If no login, it will redirect to /login page.
        /** TODO
         http.authorizeRequests().antMatchers("/users", "/users/*")
         .hasRole("ADMIN");

         // For ADMIN only.
         http.authorizeRequests().antMatchers("/components", "/components/*")
         .hasRole("ADMIN");
         */
        // When the user has logged in as XX.
        // But access a page that requires role YY,
        // AccessDeniedException will throw.
        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");

        // Config for Login Form
        http.authorizeRequests().and().formLogin()//
                // Submit URL of login page.
                .loginProcessingUrl("/j_spring_security_check") // Submit URL
                .loginPage("/login")
                .defaultSuccessUrl("/index")
                .failureUrl("/login?error=true")
                .usernameParameter("userInternalId")
                .passwordParameter("userPassword")
                // Config for Logout Page
                .and().logout().logoutUrl("/logout")
                .invalidateHttpSession(true);

    }
}