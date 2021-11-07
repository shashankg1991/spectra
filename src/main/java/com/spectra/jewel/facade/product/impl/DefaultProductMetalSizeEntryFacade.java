package com.spectra.jewel.facade.product.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

import javax.annotation.Resource;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;

import com.spectra.jewel.converter.product.ws.ProductMetalSizeEntryToProductMetalSizeEntryWsDataConverter;
import com.spectra.jewel.data.ws.ProductMetalSizeEntryWsData;
import com.spectra.jewel.facade.product.ProductMetalSizeEntryFacade;
import com.spectra.jewel.model.product.Product;
import com.spectra.jewel.model.product.ProductMetalSizeEntry;

@Component("productMetalSizeEntryFacade")
public class DefaultProductMetalSizeEntryFacade
		implements
			ProductMetalSizeEntryFacade {

	@Resource
	private ProductMetalSizeEntryToProductMetalSizeEntryWsDataConverter productMetalSizeEntryToProductMetalSizeEntryWsDataConverter;

	@Override
	public ProductMetalSizeEntryWsData getProductMetalSizeEntryWsData(
			final ProductMetalSizeEntry productMetalSizeEntry) {
		return Objects.nonNull(productMetalSizeEntry)
				? productMetalSizeEntryToProductMetalSizeEntryWsDataConverter
						.convert(productMetalSizeEntry)
				: null;
	}

	@Override
	public Collection<ProductMetalSizeEntryWsData> getProductMetalSizeEntriesWsData(
			Product product) {
		return Objects.nonNull(product)
				&& CollectionUtils.isNotEmpty(product.getMetalSizeEntries())
						? productMetalSizeEntryToProductMetalSizeEntryWsDataConverter
								.convertAll(product.getMetalSizeEntries())
						: Collections.emptySet();
	}

}
