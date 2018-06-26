package de.hska.iwi.vslab.authorizationserver;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.security.Principal;

@RestController
public class AuthorizationServerController {
  // @RequestMapping( value = "/login")
  // public Principal userInfo(@AuthenticationPrincipal Principal user){
  //   return user;
  // }
	
	 @RequestMapping(value = "/user")
	  public Principal userInfo(@AuthenticationPrincipal Principal user) {
		 System.out.println("authorization server user info controller" + user.toString());

	    return user;
	  }


//
//  @GetMapping( value = "index")
//  public String index(){
//    return "this is open";
//  }
//
//  @GetMapping( value = "secureAPI")
//  public String secureAPI(){
//    return "this is secure";
//  }
//
//  @GetMapping( value = "oauth/token")
//  public String oauthToken(){
//    System.out.println("TEST");
//    return "this is secure";
//  }

}
