package com.spectra.jewel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spectra.jewel.model.product.Price;

public interface PriceRepository extends JpaRepository<Price, Long> {

}
