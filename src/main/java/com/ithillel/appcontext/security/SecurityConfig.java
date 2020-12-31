package com.ithillel.appcontext.security;

import com.ithillel.service.security.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
@ComponentScan({"com.ithillel.appcontext.security",
        "com.ithillel.service.security"})
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomAuthenticationProvider customAuthenticationProvider;

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/login").anonymous()
                .antMatchers("/clients", "/histories").hasRole("ADMIN")
                .antMatchers(
                    "/realtor/create", "/realtor/delete,", "/realtor/delete",
                    "/history/create", "/history/delete", "/history/update", "/history",
                    "/client/create", "/client/delete", "/client/update",
                    "/region/create", "/region/delete", "/region/update")
                .hasRole("ADMIN")
            .anyRequest()
                .authenticated()
                .and()
            .formLogin()
                .defaultSuccessUrl("/", true)
                .and()
            .logout().permitAll().logoutSuccessUrl("/login")
            .and().httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(customAuthenticationProvider);
        auth.userDetailsService(userDetailsService());
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return userDetailsService;
    }
}
