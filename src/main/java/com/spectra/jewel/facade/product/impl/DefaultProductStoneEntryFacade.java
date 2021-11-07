package com.spectra.jewel.facade.product.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.spectra.jewel.converter.product.ws.ProductStoneEntryToProductStoneEntryWsDataConverter;
import com.spectra.jewel.data.ws.ProductStoneEntryWsData;
import com.spectra.jewel.facade.product.ProductStoneEntryFacade;
import com.spectra.jewel.model.product.Product;

@Component("productStoneEntryFacade")
public class DefaultProductStoneEntryFacade implements ProductStoneEntryFacade {

	@Resource
	private ProductStoneEntryToProductStoneEntryWsDataConverter productStoneEntryToProductStoneEntryWsDataConverter;

	@Override
	public Collection<ProductStoneEntryWsData> getStoneEntriesWsData(
			final Product product) {
		return Objects.nonNull(product)
				&& Objects.nonNull(product.getStonesEntries())
						? productStoneEntryToProductStoneEntryWsDataConverter
								.convertAll(product.getStonesEntries())
						: Collections.emptySet();
	}

}
