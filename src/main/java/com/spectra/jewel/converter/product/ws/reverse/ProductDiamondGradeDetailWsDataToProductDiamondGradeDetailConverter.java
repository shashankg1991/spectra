package com.spectra.jewel.converter.product.ws.reverse;

import java.util.Objects;

import javax.annotation.Resource;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;

import com.spectra.jewel.converter.PopulatingConverter;
import com.spectra.jewel.data.ws.ProductDiamondGradeDetailWsData;
import com.spectra.jewel.model.enums.DiamondGrade;
import com.spectra.jewel.model.product.ProductDiamondGradeDetail;

@Component
public class ProductDiamondGradeDetailWsDataToProductDiamondGradeDetailConverter
		extends
			PopulatingConverter<ProductDiamondGradeDetailWsData, ProductDiamondGradeDetail> {

	@Resource
	private ProductDiamondEntryWsDataToProductDiamondEntryConverter productDiamondEntryWsDataToProductDiamondEntryConverter;

	@Override
	public ProductDiamondGradeDetail convert(
			ProductDiamondGradeDetailWsData source) {
		ProductDiamondGradeDetail target = new ProductDiamondGradeDetail();
		populate(source, target);
		return target;
	}

	@Override
	public void populate(ProductDiamondGradeDetailWsData source,
			ProductDiamondGradeDetail target) {
		target.setId(source.getId());
		if (Objects.nonNull(source.getGrade())) {
			target.setGrade(DiamondGrade.valueOf(source.getGrade()));
		}
		if (CollectionUtils.isNotEmpty(source.getEntries())) {
			target.setEntries(
					productDiamondEntryWsDataToProductDiamondEntryConverter
							.convertAll(source.getEntries()));
		}
	}

}
