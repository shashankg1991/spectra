package com.spectra.jewel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spectra.jewel.model.Price;

public interface PriceRepository extends JpaRepository<Price, Long> {

}
