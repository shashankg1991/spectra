package com.spectra.jewel.facade.product.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.spectra.jewel.converter.product.ws.ProductDiamondGradeDetailToProductDiamondGradeDetailWsDataConverter;
import com.spectra.jewel.data.ws.ProductDiamondGradeDetailWsData;
import com.spectra.jewel.facade.product.ProductDiamondGradeDetailFacade;
import com.spectra.jewel.model.product.Product;
import com.spectra.jewel.model.product.ProductDiamondGradeDetail;

@Component("productDiamondGradeDetailFacade")
public class DefaultProductDiamondGradeDetailFacade
		implements
			ProductDiamondGradeDetailFacade {

	@Resource
	private ProductDiamondGradeDetailToProductDiamondGradeDetailWsDataConverter productDiamondGradeDetailToProductDiamondGradeDetailWsDataConverter;

	@Override
	public ProductDiamondGradeDetailWsData getWsProductDiamondGradeDetail(
			ProductDiamondGradeDetail diamondGradeDetail) {
		return Objects.nonNull(diamondGradeDetail)
				? productDiamondGradeDetailToProductDiamondGradeDetailWsDataConverter
						.convert(diamondGradeDetail)
				: null;
	}

	@Override
	public Collection<ProductDiamondGradeDetailWsData> getProductDiamondGradeDetailsWsData(
			Product product) {
		return Objects.nonNull(product)
				&& Objects.nonNull(product.getDiamondGradeDetails())
						? productDiamondGradeDetailToProductDiamondGradeDetailWsDataConverter
								.convertAll(product.getDiamondGradeDetails())
						: Collections.emptySet();
	}
}
