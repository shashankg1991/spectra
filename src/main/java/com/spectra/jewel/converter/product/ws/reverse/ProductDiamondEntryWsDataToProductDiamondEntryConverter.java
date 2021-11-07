package com.spectra.jewel.converter.product.ws.reverse;

import java.util.Objects;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.spectra.jewel.converter.PopulatingConverter;
import com.spectra.jewel.converter.generic.ws.reverse.PriceWsDataToPriceConverter;
import com.spectra.jewel.converter.generic.ws.reverse.WeightWsDataToWeightConverter;
import com.spectra.jewel.data.ws.ProductDiamondEntryWsData;
import com.spectra.jewel.model.enums.DiamondSize;
import com.spectra.jewel.model.product.ProductDiamondEntry;

@Component
public class ProductDiamondEntryWsDataToProductDiamondEntryConverter
		extends
			PopulatingConverter<ProductDiamondEntryWsData, ProductDiamondEntry> {

	@Resource
	private PriceWsDataToPriceConverter priceWsDataToPriceConverter;

	@Resource
	private WeightWsDataToWeightConverter weightWsDataToWeightConverter;

	@Override
	public ProductDiamondEntry convert(ProductDiamondEntryWsData source) {
		ProductDiamondEntry target = new ProductDiamondEntry();
		populate(source, target);
		return target;
	}

	@Override
	public void populate(ProductDiamondEntryWsData source,
			ProductDiamondEntry target) {
		target.setId(source.getId());
		target.setNumber(source.getNumber());
		if (Objects.nonNull(source.getSize())) {
			target.setSize(DiamondSize.valueOf(source.getSize()));
		}
		if (Objects.nonNull(source.getRate())) {
			target.setRate(
					priceWsDataToPriceConverter.convert(source.getRate()));
		}
		if (Objects.nonNull(source.getWeight())) {
			target.setWeight(
					weightWsDataToWeightConverter.convert(source.getWeight()));
		}
	}

}
