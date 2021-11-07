package com.spectra.jewel.service.impl;

import java.util.Collection;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spectra.jewel.model.product.ProductDiamondGradeDetail;
import com.spectra.jewel.repository.ProductDiamondGradeDetailRepository;
import com.spectra.jewel.service.ProductDiamondGradeDetailService;

@Service("productDiamondGradeDetailService")
public class DefaultProductDiamondGradeDetailService
		implements
			ProductDiamondGradeDetailService {
	@Autowired
	ProductDiamondGradeDetailRepository productDiamondGradeDetailRepository;

	@Override
	public void delete(
			Collection<ProductDiamondGradeDetail> diamondGradeDetails) {
		if (CollectionUtils.isNotEmpty(diamondGradeDetails)) {
			productDiamondGradeDetailRepository.deleteByIdIn(diamondGradeDetails
					.stream().map(ProductDiamondGradeDetail::getId)
					.collect(Collectors.toList()));
		}

	}

	@Override
	public ProductDiamondGradeDetail getDiamondGradeDetail(Long id) {
		return productDiamondGradeDetailRepository.findById(id).orElse(null);
	}
}
