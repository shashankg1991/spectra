package com.spectra.jewel.service;

import com.spectra.jewel.model.User;

public interface UserService {
	public void save(User user);

	public User findById(Long id);

	public User findByUserName(String userName);
}
