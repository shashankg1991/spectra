package com.spectra.jewel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spectra.jewel.model.order.Cart;
import com.spectra.jewel.model.user.User;

public interface CartRepository extends JpaRepository<Cart, Long>{

	/**
	 * find order by users
	 * 
	 * @param user 
	 * @return {@link List}
	 */
	Cart findOneByUser(User user);
}
