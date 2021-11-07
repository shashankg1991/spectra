package com.spectra.jewel.service.impl;

import java.util.Collection;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spectra.jewel.model.product.ProductMetalSizeEntry;
import com.spectra.jewel.repository.ProductMetalSizeEntryRepository;
import com.spectra.jewel.service.ProductMetalSizeEntryService;

@Service("productMetalSizeEntryService")
public class DefaultProductMetalSizeEntryService
		implements
			ProductMetalSizeEntryService {
	@Autowired
	ProductMetalSizeEntryRepository productMetalSizeEntryRepository;

	@Override
	public void delete(
			Collection<ProductMetalSizeEntry> productMetalSizeEntries) {
		if (CollectionUtils.isNotEmpty(productMetalSizeEntries)) {
			productMetalSizeEntryRepository.deleteByIdIn(productMetalSizeEntries
					.stream().map(ProductMetalSizeEntry::getId)
					.collect(Collectors.toList()));
		}
	}
}
