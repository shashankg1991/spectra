package com.spectra.jewel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spectra.jewel.model.user.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);

}
