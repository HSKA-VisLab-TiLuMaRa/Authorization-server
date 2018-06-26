package de.hska.iwi.vslab.zuulserver;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
	
	
	@Override
    public void configure(HttpSecurity http) throws Exception {
         
		System.out.println("zuul http config, resourceserver ");
		 	
		 http		
		 	.authorizeRequests().antMatchers("/auth/oauth/authorize", "/auth/oauth/token", "/auth/oauth/confirm_access").permitAll()   // important for authorizing request why??
	        .and()
	        .authorizeRequests()
			 	.antMatchers("/auth/user").authenticated()
			 	.anyRequest().authenticated();
    }


}
