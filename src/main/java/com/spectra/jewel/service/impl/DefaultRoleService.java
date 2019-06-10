package com.spectra.jewel.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.spectra.jewel.model.Role;
import com.spectra.jewel.repository.RoleRepository;
import com.spectra.jewel.service.RoleService;

@Service(value = "roleService")
public class DefaultRoleService implements RoleService {
	@Resource
	RoleRepository roleRepository;

	@Override
	public Iterable<Role> findAll() {
		return roleRepository.findAll();
	}

}
