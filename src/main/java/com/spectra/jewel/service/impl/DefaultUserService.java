package com.spectra.jewel.service.impl;

import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.spectra.jewel.model.User;
import com.spectra.jewel.repository.UserRepository;
import com.spectra.jewel.service.UserService;

@Service(value = "userService")
public class DefaultUserService implements UserService {

	@Resource
	UserRepository userRepository;

	@Resource
	PasswordEncoder passwordEncoder;

	@Override
	public void save(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);

	}

	@Override
	public User findById(Long id) {
		Optional<User> user = userRepository.findById(id);
		if (user.isPresent()) {
			return user.get();
		}
		return null;
	}

	@Override
	public User findByUserName(String username) {
		return userRepository.findByUsername(username);
	}

}
