package de.hska.iwi.vslab.authorizationserver;

import org.springframework.stereotype.Service;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
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

  public User loadUserByUsername(String username){
    String url = "http://localhost:8083/usersByUsername/" + username;
    // hier kommt ein User Objekt zurück, kein UserDetails Objekt
    User user = userRestTemplate.getForObject(url, User.class);
    return user;
  }


}
