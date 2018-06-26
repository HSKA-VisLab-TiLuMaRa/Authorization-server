package de.hska.iwi.vslab.authorizationserver;

import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    // @Override
    // @Bean
    // public UserDetailsService userDetailsServiceBean() throws Exception {
    //   return super.userDetailsServiceBean();
    // }

    // @Override
    // public void configure(AuthenticationManagerBuilder auth) throws Exception {
    //   auth.inMemoryAuthentication()
    //     .withUser("barry").password("{noop}password").roles("USER")
    //     .and()
    //     .withUser("admin").password("{noop}password").roles("USER", "ADMIN");
    // }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
      http.httpBasic()
        .and()
        .authorizeRequests()
        .antMatchers("/index").permitAll()
        .anyRequest().authenticated();
      http.csrf().disable();

        // http.requestMatchers()
        //   .antMatchers("/login", "/oauth/authorize", "/oauth/confirm_access")
        //   .and()
        //   .formLogin().loginPage("/login").permitAll().failureUrl("/login?error")
        //   .and()
        //   .authorizeRequests().anyRequest().authenticated();
    }

// barry:password
// Basic YmFycnk6cGFzc3dvcmQ=


}
