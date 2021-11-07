package com.spectra.jewel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.spectra.jewel.model.product.ProductStoneEntry;

public interface ProductStoneEntryRepository
		extends
			CrudRepository<ProductStoneEntry, Long> {
	
	@Transactional
	@Modifying
	@Query("DELETE FROM ProductStoneEntry pse WHERE pse.id IN (:ids)")
	void deleteByIdIn(List<Long> ids);

}
