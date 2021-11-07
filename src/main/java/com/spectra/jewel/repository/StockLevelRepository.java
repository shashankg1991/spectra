package com.spectra.jewel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spectra.jewel.model.product.StockLevel;

@Repository
public interface StockLevelRepository extends JpaRepository<StockLevel, Long> {
	@Transactional
	@Modifying
	@Query("DELETE FROM StockLevel sl WHERE sl.id IN (:ids)")
	void deleteByIdIn(List<Long> ids);
}
