package com.spectra.jewel.service.impl;

import java.util.Collection;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spectra.jewel.model.product.ProductDiamondEntry;
import com.spectra.jewel.repository.ProductDiamondEntryRepository;
import com.spectra.jewel.service.ProductDiamondEntryService;

@Service("productDiamondEntryService")
public class DefaultProductDiamondEntryService
		implements
			ProductDiamondEntryService {
	@Autowired
	ProductDiamondEntryRepository productDiamondEntryRepository;

	@Override
	public void delete(Collection<ProductDiamondEntry> diamondEntries) {
		if (CollectionUtils.isNotEmpty(diamondEntries)) {
			productDiamondEntryRepository.deleteByIdIn(
					diamondEntries.stream().map(ProductDiamondEntry::getId)
							.collect(Collectors.toList()));
		}
	}
}
