package com.spectra.jewel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spectra.jewel.model.enums.AddressType;
import com.spectra.jewel.model.user.Address;
import com.spectra.jewel.model.user.User;

public interface AddressRepository extends JpaRepository<Address, Long> {

	List<Address> findByUserAndAddressTypeAndActive(User user, AddressType addressType, boolean active);

}
