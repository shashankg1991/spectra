package com.spectra.jewel.service.impl;

import java.util.Collection;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spectra.jewel.model.product.ProductStoneEntry;
import com.spectra.jewel.repository.ProductStoneEntryRepository;
import com.spectra.jewel.service.ProductStoneEntryService;

@Service("productStoneEntryService")
public class DefaultProductStoneEntryService
		implements
			ProductStoneEntryService {
	@Autowired
	ProductStoneEntryRepository productStoneEntryRepository;

	@Override
	public void delete(Collection<ProductStoneEntry> productStoneEntries) {
		if (CollectionUtils.isNotEmpty(productStoneEntries)) {
			productStoneEntryRepository.deleteByIdIn(
					productStoneEntries.stream().map(ProductStoneEntry::getId)
							.collect(Collectors.toList()));
		}
	}
}
