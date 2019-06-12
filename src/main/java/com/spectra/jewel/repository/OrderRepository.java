package com.spectra.jewel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spectra.jewel.model.order.Order;
import com.spectra.jewel.model.user.User;

public interface OrderRepository extends JpaRepository<Order, Long> {

	List<Order> findByUser(User user);

    Order findByCode(String code);
}
