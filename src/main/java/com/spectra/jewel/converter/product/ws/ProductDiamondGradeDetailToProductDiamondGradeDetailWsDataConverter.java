package com.spectra.jewel.converter.product.ws;

import java.util.Objects;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.spectra.jewel.converter.PopulatingConverter;
import com.spectra.jewel.data.ws.ProductDiamondGradeDetailWsData;
import com.spectra.jewel.facade.product.ProductDiamondEntryFacade;
import com.spectra.jewel.model.product.ProductDiamondGradeDetail;

@Component
public class ProductDiamondGradeDetailToProductDiamondGradeDetailWsDataConverter
		extends
			PopulatingConverter<ProductDiamondGradeDetail, ProductDiamondGradeDetailWsData> {

	@Resource
	private ProductDiamondEntryFacade productDiamondEntryFacade;

	@Override
	public ProductDiamondGradeDetailWsData convert(
			ProductDiamondGradeDetail source) {
		ProductDiamondGradeDetailWsData target = new ProductDiamondGradeDetailWsData();
		populate(source, target);
		return target;
	}

	@Override
	public void populate(ProductDiamondGradeDetail source,
			ProductDiamondGradeDetailWsData target) {
		target.setId(source.getId());
		if (Objects.nonNull(source.getGrade())) {
			target.setGrade(source.getGrade().name());
		}
		target.setEntries(
				productDiamondEntryFacade.getDiamondEntriesWsData(source));
	}

}
