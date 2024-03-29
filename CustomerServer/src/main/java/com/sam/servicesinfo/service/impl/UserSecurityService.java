package com.sam.servicesinfo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sam.servicesinfo.domain.User;
import com.sam.servicesinfo.repository.UserRepository;

@Service
public class UserSecurityService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user =userRepository.findByUsername(username);

		if (null==user) {
		throw new UsernameNotFoundException("username not found")	;
		}
		
		return user;
	}
	
	

}
