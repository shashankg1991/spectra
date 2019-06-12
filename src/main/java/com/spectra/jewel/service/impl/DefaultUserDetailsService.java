package com.spectra.jewel.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spectra.jewel.model.Role;
import com.spectra.jewel.model.User;
import com.spectra.jewel.service.UserService;

@Service(value = "userDetailsService")
public class DefaultUserDetailsService implements UserDetailsService {

	@Resource
	UserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userService.findByUserName(username);
		if (user == null) {
			System.out.println("User not found");
			throw new UsernameNotFoundException("Username not found");
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				user.isEnabled(), true, true, true, getGrantedAuthorities(user.getRoles()));
	}

	public List<GrantedAuthority> getGrantedAuthorities(Collection<Role> roles) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>(roles.size());
		for (Role role : roles) {
			authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
		}
		return authorities;
	}

}