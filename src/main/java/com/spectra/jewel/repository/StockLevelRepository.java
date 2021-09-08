package com.spectra.jewel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spectra.jewel.model.product.StockLevel;

@Repository
public interface StockLevelRepository extends JpaRepository<StockLevel, Long> {

}
