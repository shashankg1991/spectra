package com.spectra.jewel.converter;

import org.springframework.stereotype.Component;

import com.spectra.jewel.data.ProductSizeData;
import com.spectra.jewel.model.enums.ProductSize;

@Component("productSizeToProductSizeDataConverter")
public class ProductSizeToProductSizeDataConverter
		extends
			PopulatingConverter<ProductSize, ProductSizeData> {

	@Override
	public ProductSizeData convert(ProductSize source) {
		ProductSizeData target = new ProductSizeData();
		populate(source, target);
		return target;
	}

	@Override
	public void populate(ProductSize source, ProductSizeData target) {
		target.setCode(source.toString());
		target.setName(source.getName());
	}

}
