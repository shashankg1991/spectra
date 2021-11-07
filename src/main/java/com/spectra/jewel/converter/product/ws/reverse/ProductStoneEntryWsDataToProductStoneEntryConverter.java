package com.spectra.jewel.converter.product.ws.reverse;

import java.util.Objects;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.spectra.jewel.converter.PopulatingConverter;
import com.spectra.jewel.converter.generic.ws.reverse.PriceWsDataToPriceConverter;
import com.spectra.jewel.converter.generic.ws.reverse.WeightWsDataToWeightConverter;
import com.spectra.jewel.data.ws.ProductStoneEntryWsData;
import com.spectra.jewel.facade.generic.WeightFacade;
import com.spectra.jewel.model.product.ProductStoneEntry;

@Component
public class ProductStoneEntryWsDataToProductStoneEntryConverter
		extends
			PopulatingConverter<ProductStoneEntryWsData, ProductStoneEntry> {

	@Resource
	private PriceWsDataToPriceConverter priceWsDataToPriceConverter;

	@Resource
	private WeightWsDataToWeightConverter weightWsDataToWeightConverter;

	@Resource
	private WeightFacade weightFacade;

	@Override
	public ProductStoneEntry convert(final ProductStoneEntryWsData source) {
		ProductStoneEntry target = new ProductStoneEntry();
		populate(source, target);
		return target;
	}

	@Override
	public void populate(final ProductStoneEntryWsData source,
			ProductStoneEntry target) {
		target.setId(source.getId());
		target.setDescription(source.getDescription());
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
