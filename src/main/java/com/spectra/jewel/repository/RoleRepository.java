package com.spectra.jewel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spectra.jewel.model.user.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
