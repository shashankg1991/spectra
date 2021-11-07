package com.spectra.jewel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.spectra.jewel.model.product.ProductDiamondGradeDetail;

public interface ProductDiamondGradeDetailRepository
		extends
			JpaRepository<ProductDiamondGradeDetail, Long> {
	@Transactional
	@Modifying
	@Query("DELETE FROM ProductDiamondGradeDetail pdgd WHERE pdgd.id IN (:ids)")
	void deleteByIdIn(List<Long> ids);
}
