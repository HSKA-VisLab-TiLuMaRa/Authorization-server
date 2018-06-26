package de.hska.iwi.vslab.authorizationserver;

import org.springframework.security.core.GrantedAuthority;
import java.util.Collection;
import org.springframework.security.core.userdetails.UserDetails;

public class User implements UserDetails {

	private Long id;
	private String username;
	private String passwd;
	private String firstname;
	private String lastname;
	private Integer roleId;

	public User(){}

	public User(Long id, String username, String pwd, String firstname, String lastname, Integer roleId) {
		this.id = id;
		this.username = username;
		this.passwd = pwd;
		this.firstname = firstname;
		this.lastname = lastname;
		this.roleId = roleId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public String getPassword() {
		return passwd;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", passwd=" + passwd + "]";
	}

	 @Override
	 public Collection<? extends GrantedAuthority> getAuthorities() {
	   return null;
	 }

	 @Override
	 public boolean isAccountNonExpired() {
	   return true;
	 }

	 @Override
	 public boolean isAccountNonLocked() {
	   return true;
	 }

	 @Override
	 public boolean isCredentialsNonExpired() {
	   return true;
	 }

	 @Override
	 public boolean isEnabled() {
	   return true;
	 }

}
