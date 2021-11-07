package com.spectra.jewel.converter.product.ws.reverse;

import java.util.Objects;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.spectra.jewel.converter.PopulatingConverter;
import com.spectra.jewel.converter.generic.ws.reverse.WeightWsDataToWeightConverter;
import com.spectra.jewel.data.ws.ProductMetalSizeEntryWsData;
import com.spectra.jewel.model.enums.MetalPurity;
import com.spectra.jewel.model.enums.ProductSize;
import com.spectra.jewel.model.product.ProductMetalSizeEntry;

@Component
public class ProductMetalSizeEntryWsDataToProductMetalSizeEntryConverter
		extends
			PopulatingConverter<ProductMetalSizeEntryWsData, ProductMetalSizeEntry> {

	@Resource
	WeightWsDataToWeightConverter weightWsDataToWeightConverter;

	@Override
	public ProductMetalSizeEntry convert(ProductMetalSizeEntryWsData source) {
		ProductMetalSizeEntry target = new ProductMetalSizeEntry();
		populate(source, target);
		return target;
	}

	@Override
	public void populate(ProductMetalSizeEntryWsData source,
			ProductMetalSizeEntry target) {
		target.setId(source.getId());
		if (Objects.nonNull(source.getSize())) {
			target.setSize(ProductSize.valueOf(source.getSize()));
		}
		if (Objects.nonNull(source.getMetalPurity())) {
			target.setPurity(MetalPurity.valueOf(source.getMetalPurity()));
		}
		if (Objects.nonNull(source.getWeight())) {
			target.setWeight(
					weightWsDataToWeightConverter.convert(source.getWeight()));
		}
	}

}
