package com.spectra.jewel.service;

import com.spectra.jewel.exception.DuplicateException;
import com.spectra.jewel.model.User;

public interface UserService {
	public void register(User user) throws DuplicateException;

	public User findById(Long id);

	public User findByUserName(String userName);
}
