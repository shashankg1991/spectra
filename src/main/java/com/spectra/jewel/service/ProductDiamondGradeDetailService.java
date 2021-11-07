package com.spectra.jewel.service;

import java.util.Collection;

import com.spectra.jewel.model.product.ProductDiamondGradeDetail;

public interface ProductDiamondGradeDetailService {

	void delete(Collection<ProductDiamondGradeDetail> diamondGradeDetails);
	
	ProductDiamondGradeDetail getDiamondGradeDetail(Long id);

}
