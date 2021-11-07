package com.spectra.jewel.facade.product.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.spectra.jewel.converter.product.ws.ProductDiamondEntryToProductDiamondEntryWsDataConverter;
import com.spectra.jewel.data.ws.ProductDiamondEntryWsData;
import com.spectra.jewel.facade.product.ProductDiamondEntryFacade;
import com.spectra.jewel.model.product.ProductDiamondGradeDetail;

@Component("productDiamondEntryFacade")
public class DefaultProductDiamondEntryFacade
		implements
			ProductDiamondEntryFacade {

	@Resource
	private ProductDiamondEntryToProductDiamondEntryWsDataConverter productDiamondEntryToProductDiamondEntryWsDataConverter;

	@Override
	public Collection<ProductDiamondEntryWsData> getDiamondEntriesWsData(
			ProductDiamondGradeDetail diamondGradeDetail) {
		return Objects.nonNull(diamondGradeDetail)
				&& Objects.nonNull(diamondGradeDetail.getEntries())
						? productDiamondEntryToProductDiamondEntryWsDataConverter
								.convertAll(diamondGradeDetail.getEntries())
						: Collections.emptySet();
	}

}
