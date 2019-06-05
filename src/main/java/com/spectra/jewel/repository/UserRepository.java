package com.spectra.jewel.repository;

import org.springframework.data.repository.CrudRepository;

import com.spectra.jewel.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
