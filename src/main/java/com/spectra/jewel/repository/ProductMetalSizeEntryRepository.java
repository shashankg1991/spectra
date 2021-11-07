package com.spectra.jewel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.spectra.jewel.model.product.ProductMetalSizeEntry;

public interface ProductMetalSizeEntryRepository
		extends
			JpaRepository<ProductMetalSizeEntry, Long> {
	@Transactional
	@Modifying
	@Query("DELETE FROM ProductMetalSizeEntry pmse WHERE pmse.id IN (:ids)")
	void deleteByIdIn(List<Long> ids);
}
