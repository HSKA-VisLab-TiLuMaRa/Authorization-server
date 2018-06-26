package de.hska.iwi.vslab.authorizationserver;

import org.springframework.stereotype.Service;
import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

@Service
public class NewUserDetailsService implements UserDetailsService {

  // static final Long serialVersionUID = 1L;

  @Autowired
	private RestTemplate userRestTemplate;

  @Bean
  public RestTemplate userRestTemplate(RestTemplateBuilder builder) {
    return builder.build();
  }

  public UserDetails loadUserByUsername(String username){
    String url = "http://localhost:8083/usersByUsername/" + username;
    // hier kommt ein User Objekt zurück, kein UserDetails Objekt
    UserDetails userdetails = userRestTemplate.getForObject(url, UserDetails.class);
    return userdetails;
  }
//
//  @Override
//  public Collection<? extends GrantedAuthority> getAuthorities() {
//    return null;
//  }
//
//  @Override
//  public String getPassword() {
//    return "password";
//  }
//
//  @Override
//  public String getUsername() {
//    return "bbuilder";
//  }
//
//  @Override
//  public boolean isAccountNonExpired() {
//    return true;
//  }
//
//  @Override
//  public boolean isAccountNonLocked() {
//    return true;
//  }
//
//  @Override
//  public boolean isCredentialsNonExpired() {
//    return true;
//  }
//
//  @Override
//  public boolean isEnabled() {
//    return true;
//  }

}
