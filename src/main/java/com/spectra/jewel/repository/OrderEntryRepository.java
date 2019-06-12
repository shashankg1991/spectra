package com.spectra.jewel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spectra.jewel.model.order.OrderEntry;

public interface OrderEntryRepository extends JpaRepository<OrderEntry, Long>  {

}
